package com.example.springbookscrudapp.repository;


import com.example.springbookscrudapp.model.Book;
import org.springframework.data.repository.CrudRepository;


/**
 * @author platoiscoding.com
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
