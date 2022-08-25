package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("dao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(Book book) {
        return bookDao.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookDao.selectBookByTitle(title);
    }

    public int deleteBookByTitle(String title) {
        return bookDao.deleteBookByTitle(title);
    }

    public int updateBookByTitle(String title, Book book) {
        return bookDao.updateBookByTitle(title, book);
    }

}
