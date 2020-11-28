package org.bookAPI.controller;

import org.bookAPI.beans.Book;
import org.bookAPI.beans.MemoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/books")
public class BookController {

    private final MemoryBookService bookService;

    @Autowired
    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @GetMapping("/getBook")
    public List<Book> helloBook() {
        return bookService.getBookList();
    }

    @ResponseBody
    @GetMapping("/getBook/{id}")
    public Book helloBook(@PathVariable long id) {
        return bookService.get(id);
    }

    @GetMapping(path = "/addBook")
    public String addBookView() {
        return "createBookForm";
    }

    @ResponseBody
    @PostMapping(path = "/addBook")
    public String addBook() {
//        bookService.addBook(book);
        return "TEST";
    }

    @ResponseBody
    @GetMapping("/removeBook/{id}")
    public String removeBook(@PathVariable long id) {
        bookService.removeBook(id);
        return "done";
    }

}