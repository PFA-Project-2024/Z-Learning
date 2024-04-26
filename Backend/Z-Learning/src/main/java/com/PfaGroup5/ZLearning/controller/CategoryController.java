package com.PfaGroup5.ZLearning.controller;

import com.PfaGroup5.ZLearning.model.Category;
import com.PfaGroup5.ZLearning.model.Certif;
import com.PfaGroup5.ZLearning.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Api/Category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }




    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<Certif>> getAllCertifsByCategory(@PathVariable String id) {
        if (categoryService.getAllCertifsByCategory(id) != null) {
            return ResponseEntity.ok(categoryService.getAllCertifsByCategory(id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
