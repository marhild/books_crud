package com.example.springbookscrudapp.service;

import com.example.springbookscrudapp.model.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author platoiscoding.com
 */
@Service
public interface CategoryService extends CrudService<Category, Long> {

    /**
     * gets all Categories from Database
     * @return  a Set containing Categories
     */
    Set<Category> getAll();

    /**
     * finds a Category in DB by its ID
     * @param catId    Database ID of Category
     * @return          Category with ID = catId
     */
    Category findById(Long catId);

    /**
     * creates and inserts a new Category in DB
     * @param categoryDetails      Category details from NEW Cat. FROM
     * @return                     id of new Category
     */
    Long create(Category categoryDetails);

    /**
     * Updates a Category with
     * @param catId                ID of Category
     * @param categoryDetails      Category details from EDIT FORM
     */
    void update(Long catId, Category categoryDetails);

    /**
     * delete a Category from DB
     * @param catId     ID of Category
     */
    void delete(Long catId);
}
