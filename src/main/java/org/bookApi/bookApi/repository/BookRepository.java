package org.bookApi.bookApi.repository;

import org.bookApi.bookApi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, CrudRepository<Book, Long> {

    @Query("select b from Book b")
    List<Book> getAllBooks();

    Optional<Book> findBookById(Long id);


}
