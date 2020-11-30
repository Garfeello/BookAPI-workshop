package org.bookAPI.interfaces;

import org.bookAPI.beans.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookList();

    void addBook(Book book);

    void removeBook(long id);

    Book get(long id);

    void update(Book book);
}
