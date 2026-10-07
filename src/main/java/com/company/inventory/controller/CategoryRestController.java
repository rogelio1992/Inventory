package com.company.inventory.controller;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryDao categoryDao;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        return categoryService.getCategories();
    }

    public CategoryRestController(ICategoryDao categoryDao, ICategoryService categoryService) {
        this.categoryDao = categoryDao;
        this.categoryService = categoryService;
    }
}
