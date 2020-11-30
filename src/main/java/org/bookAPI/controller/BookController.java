package org.bookAPI.controller;

import org.bookAPI.beans.Book;
import org.bookAPI.beans.MemoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final MemoryBookService bookService;

    @Autowired
    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBook")
    public List<Book> getBooks() {
        return bookService.getBookList();
    }

    @GetMapping("/getBook/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.get(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @DeleteMapping("/removeBook/{id}")
    public String removeBook(@PathVariable long id) {
        bookService.removeBook(id);
        return "Deleted book with ID: " + id;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        bookService.update(book);
        return book;
    }


}