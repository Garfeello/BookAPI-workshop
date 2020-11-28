package org.bookAPI.main;

import org.bookAPI.beans.Book;
import org.bookAPI.beans.MemoryBookService;

import java.util.ArrayList;
import java.util.List;

public class tst {

    public static void main(String[] args) {
        MemoryBookService memoryBookService = new MemoryBookService();
        memoryBookService.getBookList().add(new Book("a", "b", "c", "d", "e"));
        memoryBookService.getBookList().forEach(System.out::println);
        memoryBookService.removeBook(2);
        System.out.println(" ");
        memoryBookService.getBookList().forEach(System.out::println);



    }

}
