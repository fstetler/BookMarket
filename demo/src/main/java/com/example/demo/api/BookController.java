package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{title}")
    public Book getBookByTitle(@PathVariable("title") String title) {
        return bookService.getBookByTitle(title).orElse(null);
    }

    @DeleteMapping(path = "{title}")
    public void deleteBookByTitle(@PathVariable("title") String title) {
        bookService.deleteBookByTitle(title);
    }

    @PutMapping(path = "{title}")
    public void updateBookByTitle(@PathVariable("title") String title, @RequestBody Book book) {
        bookService.updateBookByTitle(title, book);
    }
}
