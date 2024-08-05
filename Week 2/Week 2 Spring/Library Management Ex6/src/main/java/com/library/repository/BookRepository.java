package com.library.repository;

import com.library.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void save(Book book) {
        System.out.println("Saving book: " + book);
    }
}
