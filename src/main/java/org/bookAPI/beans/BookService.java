package org.bookAPI.beans;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBookList();

    void addBook(Book book);

    void removeBook(long id);

    Book get(long id);
}
