package com.example.springbookscrudapp.service;

import com.example.springbookscrudapp.model.Category;
import com.example.springbookscrudapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author platoiscoding.com
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * gets all Categories from Database
     * @return  a Set containing Categories
     */
    @Override
    public Set<Category> getAll(){
        Set<Category> categorySet = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categorySet::add);
        return categorySet;
    }

    /**
     * finds a Category in DB by its ID
     * @param catId     Database ID of Category
     * @return          Category with ID = catId
     */
    @Override
    public Category findById(Long catId){
        Optional<Category> categoryOptional = categoryRepository.findById(catId);

        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category Not Found!");
        }
        return categoryOptional.get();
    }

    /**
     * delete a Category from DB
     * @param catId     ID of Category
     */
    @Override
    public void delete(Long catId){
        categoryRepository.deleteById(catId);
    }

    /**
     * creates and inserts a new Category in DB
     * @param categoryDetails      Category details from NEW Cat. FROM
     * @return                     id of new Category
     */
    @Override
    public Long create(Category categoryDetails){
        categoryRepository.save(categoryDetails);
        return categoryDetails.getId();
    }

    /**
     * Updates a Category with
     * @param catId                ID of Category
     * @param categoryDetails      Category details from EDIT FORM
     */
    @Override
    public void update(Long catId, Category categoryDetails){
        Category currentCat = findById(catId);
        currentCat.setName(categoryDetails.getName());

        categoryRepository.save(currentCat);
    }

}
