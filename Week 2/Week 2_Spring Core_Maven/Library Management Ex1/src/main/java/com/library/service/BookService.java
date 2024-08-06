package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }
}
