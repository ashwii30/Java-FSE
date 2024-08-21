package com.bookstore.api.BookstoreAPI.Book;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstore.api.BookstoreAPI.ErrorHandling.ResourceNotFoundException;
import com.bookstore.api.BookstoreAPI.ErrorHandling.UnauthorizedException;
import com.bookstore.api.BookstoreAPI.ErrorHandling.ValidationException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Custom-Header", "CustomValue");
            headers.add("X-Powered-By", "Spring Boot");
            return new ResponseEntity<>(book.get(), headers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Book with ID " + id + " not found");
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "CustomValue");
        headers.add("X-Powered-By", "Spring Boot");
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Example validation check
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new ValidationException("Book title is required");
        }
        Book createdBook = bookRepository.save(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "CustomValue");
        headers.add("X-Powered-By", "Spring Boot");
        return new ResponseEntity<>(createdBook, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            Book updatedBook = bookRepository.save(book);
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Custom-Header", "CustomValue");
            headers.add("X-Powered-By", "Spring Boot");
            return new ResponseEntity<>(updatedBook, headers, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Book with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Example unauthorized check
        boolean userIsAuthorized = false; // Replace with actual authorization logic
        if (!userIsAuthorized) {
            throw new UnauthorizedException("User is not authorized to delete books");
        }

        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Custom-Header", "CustomValue");
            headers.add("X-Powered-By", "Spring Boot");
            return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
        } else {
            throw new ResourceNotFoundException("Book with ID " + id + " not found");
        }
    }
}
