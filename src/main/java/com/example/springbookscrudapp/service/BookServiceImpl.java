package com.example.springbookscrudapp.service;


import com.example.springbookscrudapp.model.Book;
import com.example.springbookscrudapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author platoiscoding.com
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * gets all Books from Database
     * @return  a Set containing Books
     */
    @Override
    public Set<Book> getAll(){
        Set<Book> bookSet = new HashSet<>();
        bookRepository.findAll().iterator().forEachRemaining(bookSet::add);
        return bookSet;
    }

    /**
     * finds a Book in DB by its ID
     * @param bookId    Database ID of Book
     * @return          Book with ID = bookId
     */
    @Override
    public Book findById(Long bookId){
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (!bookOptional.isPresent()) {
            throw new RuntimeException("Book Not Found!");
        }
        return bookOptional.get();
    }

    /**
     * Updates a Book with
     * @param bookId                ID of Book
     * @param bookDetails           Book details from EDIT FORM
     */
    @Override
    public void update(Long bookId, Book bookDetails){
        Book currentBook = findById(bookId);
        currentBook.setTitle(bookDetails.getTitle());
        currentBook.setAuthor(bookDetails.getAuthor());
        currentBook.setCategories(bookDetails.getCategories());
        currentBook.setDescription(bookDetails.getDescription());
        currentBook.setDateField(bookDetails.getDateField());

        bookRepository.save(currentBook);
    }

    /**
     * delete a Book from DB
     * @param bookId     ID of Book
     */
    @Override
    public void delete(Long bookId){
        bookRepository.deleteById(bookId);
    }

    /**
     * creates and inserts a new Book in DB
     * @param bookDetails      Book details from NEW Book FROM
     * @return                 id of new Book
     */
    @Override
    public Long create(Book bookDetails){
        bookRepository.save(bookDetails);
        return bookDetails.getId();
    }
}
