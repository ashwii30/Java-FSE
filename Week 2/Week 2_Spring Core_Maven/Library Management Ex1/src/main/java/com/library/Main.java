package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.model.Book;
import com.library.service.BookService;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        bookService.addBook(new Book("1984", "George Orwell"));
        bookService.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        Book book = bookService.getBook("1984");
        System.out.println("Retrieved Book: " + book);

        System.out.println("All Books:");
        for (Book b : bookService.listBooks()) {
            System.out.println(b);
        }
    }
}
