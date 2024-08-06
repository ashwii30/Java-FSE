package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> listBooks() {
        return books;
    }
}
