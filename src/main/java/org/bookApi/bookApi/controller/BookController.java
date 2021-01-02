package org.bookApi.bookApi.controller;

import org.bookApi.bookApi.model.Book;
import org.bookApi.bookApi.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookRepository bookRepository;

    private BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/getAllBooks")
    private List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }

    @GetMapping("/getBook/{id}")
    private Book getBookById(@PathVariable long id) {
        return bookRepository.findBookById(id).stream().findFirst().orElse(null);
    }

    @PostMapping(value = "/addBook", produces = "application/json")
    private Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/removeBook/{id}")
    private String removeBook(@PathVariable long id) {
        bookRepository.deleteById(id);
        return "Deleted book with ID: " + id;
    }

    @PutMapping("/updateBook")
    private Book updateBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}