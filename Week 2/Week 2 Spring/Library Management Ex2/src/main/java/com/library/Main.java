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

        Book book1 = new Book("1984", "George Orwell");
        bookService.addBook(book1);

        Book retrievedBook = bookService.getBook("1984");
        System.out.println(retrievedBook);
    }
}
