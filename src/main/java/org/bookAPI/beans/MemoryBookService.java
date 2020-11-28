package org.bookAPI.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MemoryBookService implements BookService {

    private List<Book> bookList;

    public MemoryBookService() {
        this.bookList = new ArrayList<>(Arrays.asList(
                new Book("9780007525546", "The Lord of the Rings", "J. R. R. Tolkien", "PWN", "Fantasy fiction"),
                new Book("0747532699", "J. K. Rowling", "Harry Potter & Philosopher's Stone", "Bloomsbury Pub Limited", "Fantasy fiction"),
                new Book("9780132350884", "Robert C. Martin", "Clean Code", "Pearson Education", "Computers"),
                new Book("9780345307354", "Star Wars", "George Lucas", "Del Rey", "Sci-Fi"),
                new Book("9781451648546", "Steve Jobs", "Walter Isaacson", "Simon and Schuster", "Biography")
        ));
    }

    @Override
    public List<Book> getBookList() {
        return this.bookList;
    }

    @Override
    public Book get(long id) {
        return bookList.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public void removeBook(long id) {
        bookList.remove(get(id));
    }

}
