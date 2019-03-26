package com.example.springbookscrudapp.repository;


import com.example.springbookscrudapp.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author platoiscoding.com
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
