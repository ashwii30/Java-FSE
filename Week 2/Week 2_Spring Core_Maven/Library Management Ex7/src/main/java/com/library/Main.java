package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.model.Book;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        Book book1 = new Book("Book Title 1", "Author 1");
        bookService.addBook(book1);

        System.out.println(bookService.getBook("Book Title 1"));
        System.out.println(bookService.listBooks());
    }
}
