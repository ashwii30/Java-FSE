package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public Book getBook(String title) {
        return bookRepository.getBook(title);
    }

    public void listBooks() {
        for (Book book : bookRepository.listBooks()) {
            System.out.println(book);
        }
    }
}
