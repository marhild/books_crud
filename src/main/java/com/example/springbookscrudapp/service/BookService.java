package com.example.springbookscrudapp.service;

import org.springframework.stereotype.Service;

import com.example.springbookscrudapp.model.Book;
import java.util.Set;

/**
 * @author platoiscoding.com
 */
@Service
public interface BookService extends CrudService<Book, Long> {

    /**
     * gets all Books from Database
     * @return  a Set containing Books
     */
    Set<Book> getAll();

    /**
     * finds a Book in DB by its ID
     * @param bookId    Database ID of Book
     * @return          Book with ID = bookId
     */
    Book findById(Long bookId);

    /**
     * creates and inserts a new Book in DB
     * @param bookDetails      Book details from NEW Book FROM
     * @return                 id of new Book
     */
    Long create(Book bookDetails);

    /**
     * Updates a Book with
     * @param bookId                ID of Book
     * @param bookDetails           Book details from EDIT FORM
     */
    void update(Long bookId, Book bookDetails);

    /**
     * delete a Book from DB
     * @param bookId     ID of Book
     */
    void delete(Long bookId);

}
