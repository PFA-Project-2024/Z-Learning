package com.PfaGroup5.ZLearning.Controller;


import com.PfaGroup5.ZLearning.model.Certif;
import com.PfaGroup5.ZLearning.service.CertifService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
    @RequestMapping("Api/Certif")
public class CertifController {

    private final CertifService certifService;

    public CertifController(CertifService certifService) {
        this.certifService = certifService;
    }

    @PostMapping
    public ResponseEntity addCertif(@RequestBody Certif certif) {
        certifService.addCertif(certif);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Certif>> getAllCertif() {
        return ResponseEntity.ok(certifService.getAllCertif());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Certif> getCertifByName(@PathVariable String name) {
        return ResponseEntity.ok(certifService.getCertifByName(name));
    }

    @PutMapping
    public ResponseEntity updateCertif(@RequestBody Certif certif) {
        certifService.updateCertif(certif);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/uploadCertifImage/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable String id, @RequestParam("file") MultipartFile file){
        try {
            certifService.storeImage(id, file);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }
    /*@GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable String id){
        byte[] imageData = certifService.loadImage(id);
        if (imageData != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Set the content type of the response
            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }

    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCertif(@PathVariable String id) {
        certifService.deleteCertif(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
