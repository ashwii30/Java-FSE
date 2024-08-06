package com.library;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook(new Book("1984", "George Orwell"));
        bookService.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        bookService.listBooks();
    }
}
