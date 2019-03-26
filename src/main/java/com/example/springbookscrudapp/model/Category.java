package com.example.springbookscrudapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
/**
 * @author platoiscoding.com
 */
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name ="cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Book> books;

    public Category() {}

    public Category(@NotEmpty String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

