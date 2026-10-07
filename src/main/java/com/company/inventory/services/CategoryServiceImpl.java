package com.company.inventory.services;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> getCategories() {
        CategoryResponseRest response = new CategoryResponseRest();
        try {
            List<Category> categories = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategories(categories);
            response.setMetadata("Respuesta OK", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta NOK", "-1", "Error al consultar categorias");
            e.getStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
