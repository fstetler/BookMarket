package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    int insertBook(Book book);

    default int addBook(Book book) {
        return insertBook(book);
    }

    List<Book> selectAllBooks();

    Optional<Book> selectBookByTitle(String title);

    int deleteBookByTitle(String title);

    int updateBookByTitle(String title, Book book);
}
