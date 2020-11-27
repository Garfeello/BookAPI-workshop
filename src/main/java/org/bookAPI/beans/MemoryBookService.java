package org.bookAPI.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MemoryBookService {

    private List<Book> bookList;

    public MemoryBookService() {
        this.bookList = Arrays.asList(
                new Book(1L, "9780007525546", "The Lord of the Rings", "J. R. R. Tolkien", "PWN", "Fantasy fiction"),
                new Book(2L, "0747532699", "J. K. Rowling", "Harry Potter & Philosopher's Stone", "Bloomsbury Pub Limited", "Fantasy fiction"),
                new Book(3L, "9780132350884", "Robert C. Martin", "Clean Code", "Pearson Education", "Computers"),
                new Book(4L, "9780345307354", "Star Wars", "George Lucas", "Del Rey", "Sci-Fi"),
                new Book(5L, "9781451648546", "Steve Jobs", "Walter Isaacson", "Simon and Schuster", "Biography")
        );
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

}
