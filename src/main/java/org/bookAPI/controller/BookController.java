package org.bookAPI.controller;

import org.bookAPI.beans.Book;
import org.bookAPI.beans.MemoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final MemoryBookService bookService;

    @Autowired
    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBook")
    public List<Book> helloBook() {
        return bookService.getBookList();
    }

    @GetMapping("/getBook/{id}")
    public Book helloBook(@PathVariable long id) {
        return bookService.getBookList().stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    @Primary
    @GetMapping("/addBook")
    public String addBookView() {
        return "createBookForm";
    }

    @ResponseBody
    @PostMapping("/addBook")
    public String addBook(@RequestParam long id,
                          @RequestParam String isbn,
                          @RequestParam String title,
                          @RequestParam String author,
                          @RequestParam String publisher,
                          @RequestParam String type) {
        Book book = new Book(id, isbn, title, author, publisher, type);
        bookService.addBook(book);
        return "Created book " + book.toString() + " <a href=/books/addBook> Book form</a>";
    }

}