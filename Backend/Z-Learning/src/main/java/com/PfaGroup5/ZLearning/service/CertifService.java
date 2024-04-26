package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Certif;
import com.PfaGroup5.ZLearning.repository.CategoryRepo;
import com.PfaGroup5.ZLearning.repository.CertifRepo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CertifService {

    private final CertifRepo certifRepo;
    private final CategoryRepo categoryRepo;

    public CertifService(CertifRepo certifRepo, CategoryRepo categoryRepo) {
        this.certifRepo = certifRepo;
        this.categoryRepo = categoryRepo;
    }

    public void addCertif(Certif certif) {
        certifRepo.insert(certif);
        Certif savedCertif = certifRepo.findByName(certif.getName()).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Certif by Name %s", certif.getName())));


        String categoryName = certif.getCategoryName();
        Category category = categoryRepo.findByName(categoryName);
        if (category == null) {
            // Create a new category
            category = new Category();
            category.setName(categoryName);
            category.getCertifId().add(savedCertif.getId());
            categoryRepo.insert(category);
        } else {
            // Add the certificate to the existing category
            category.getCertifId().add(savedCertif.getId());
            categoryRepo.save(category);
        }




    }
    public List<Certif> getAllCertif(){
        return certifRepo.findAll();
    }

    public Certif getCertifByName(String name){
        return certifRepo.findByName(name).orElse(null);
    }

    public void updateCertif(Certif certif) {
        // when updating a certificate, we need to update the category as well if the category name has changed
        // so we need to check if the category name has changed
        Certif savedCertif = certifRepo.findByName(certif.getName())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Certif by Name %s", certif.getName())));
        String oldCategoryName = savedCertif.getCategoryName();
        String newCategoryName = certif.getCategoryName();
        Category cat = categoryRepo.findByName(newCategoryName);
        if(cat == null) {
            Category category = new Category();
            category.setName(newCategoryName);
            categoryRepo.insert(category);
        }

        if(!Objects.equals(oldCategoryName ,newCategoryName )){

            Category cat1 = categoryRepo.findByName(oldCategoryName);
            cat1.getCertifId().remove(savedCertif.getId());
            categoryRepo.save(cat1);
          //categoryRepo.findByName(newCategoryName).getCertifId().add(savedCertif.getId());
            Category cat2 = categoryRepo.findByName(newCategoryName);
            cat2.getCertifId().add(savedCertif.getId());
            categoryRepo.save(cat2);

        }
        savedCertif.setName(certif.getName());
        savedCertif.setCategoryName(certif.getCategoryName());
        savedCertif.setPrice(certif.getPrice());
        savedCertif.setMainImagePath(certif.getMainImagePath());
        savedCertif.setDescription(certif.getDescription());

        certifRepo.save(savedCertif);



    }
    public void storeImage(String certifId, MultipartFile file) {
        Certif certif = certifRepo.findById(certifId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Certif by ID %s", certifId)));

        String originalFilename = file.getOriginalFilename();
        int lastDotIndex = originalFilename.lastIndexOf(".");
        String fileExtension = (lastDotIndex != -1) ? originalFilename.substring(lastDotIndex + 1) : "";
        try {
            // path will be changed after deployement
            file.transferTo(new File("/home/ahmed/Z-learning/recources/" + certif.getId() + "_" + LocalDateTime.now().withSecond(0).withNano(0) + fileExtension));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving file");
        }
        String image = "/home/ahmed/Z-learning/recources/" + certif.getId() + "_" + LocalDateTime.now().withSecond(0).withNano(0) + fileExtension;
        if (certif != null) {
            certif.setMainImagePath(image);
            certifRepo.save(certif);
        }
    }


    public byte[] getImageContent(String certifId) throws IOException {
        Certif certif = certifRepo.findById(certifId)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Certif by ID %s", certifId)));

        String imagePath = certif.getMainImagePath();
        File file = new File(imagePath);

        return Files.readAllBytes(file.toPath());
    }

    public ArrayList<Certif> getAllCertifsByIds(ArrayList<String> ids){
        ArrayList<Certif> certifs = new ArrayList<>();
        for (String id : ids){
            certifs.add(certifRepo.findById(id).orElse(null));
        }
        return certifs;
    }
    public void deleteCertif(String id){
        certifRepo.deleteById(id);
    }
}
