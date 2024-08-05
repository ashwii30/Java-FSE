package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.model.Book;
import com.library.service.BookService;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        bookService.addBook(book);
    }
}
