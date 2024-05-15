package com.PfaGroup5.ZLearning.service;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Certif;
import com.PfaGroup5.ZLearning.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final CertifService certifService;

    public CategoryService(CategoryRepo categoryRepo , CertifService CertifService) {
        this.categoryRepo = categoryRepo;
        this.certifService =  CertifService;
    }

    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }

    public void EditIdList(String action, String categotyName ,String certifIf){
        if (action.equals("add")){
            Category category = categoryRepo.findByName(categotyName);
            category.getCertifId().add(certifIf);
            categoryRepo.save(category);
        }else if (action.equals("remove")){
            Category category = categoryRepo.findByName(categotyName);
            category.getCertifId().remove(certifIf);
            categoryRepo.save(category);
        }
    }



    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public ArrayList<Certif> getAllCertifsByCategory(String id){
        Category categoryy = categoryRepo.findById(id).orElse(null);
        if (categoryy != null){
            ArrayList<String> certifs = new ArrayList<>();
            certifs = categoryy.getCertifId();
            ArrayList<Certif> certifList = new ArrayList<>();
            return certifList = certifService.getAllCertifsByIds(certifs);
        }
        return null;
    }

    public Category addCategory(Category category) {

        Category categories = categoryRepo.findByName(category.getName());
        if (categories != null) {
            return null;
        }
        categoryRepo.insert(category);
        return category;
    }
}
