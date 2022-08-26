package com.example.demo.dao;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("dao")
public class DataAccessService implements AuthorDao, BookDao {

    private static List<Author> DBAuthor = new ArrayList<>();
    private static List<Book> DBBook = new ArrayList<>();

    @Override
    public int insertAuthor(Author author) {
        DBAuthor.add(new Author(author.getName(), author.getPseudonym()));
        return 1;
    }

    @Override
    public int insertBook(Book book) {
        DBBook.add(new Book(book.getTitle(), book.getDescription(), book.getAuthor(), book.getPrice()));
        return 1;
    }

    @Override
    public List<Book> selectAllBooks() {
        return DBBook;
    }

    @Override
    public List<Author> selectAllAuthors() {
        return DBAuthor;
    }

    @Override
    public Optional<Author> selectAuthorByPseudonym(String pseudonym) {
        return DBAuthor.stream()
                .filter(author -> author.getPseudonym().equals(pseudonym))
                .findFirst();
    }

    @Override
    public Optional<Book> selectBookByTitle(String title) {
        return DBBook.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public int deleteBookByTitle(String title) {
        Optional<Book> bookMaybe = selectBookByTitle(title);
        if (bookMaybe.isEmpty()) {
            return 0;
        }
        DBBook.remove(bookMaybe.get());
        return 1;
    }

    @Override
    public int deleteAuthorByPseudonym(String pseudonym) {
        Optional<Author> authorMaybe = selectAuthorByPseudonym(pseudonym);
        if (authorMaybe.isEmpty()) {
            return 0;
        }
        DBAuthor.remove(authorMaybe.get());
        return 1;
    }

    @Override
    public int updateBookByTitle(String title, Book update) {
        return selectBookByTitle(title)
                .map(book -> {
                    int indexOfBookToUpdate = DBBook.indexOf(book);
                    if (indexOfBookToUpdate >= 0) {
                        DBBook.set(indexOfBookToUpdate, new Book(title, update.getDescription(), update.getAuthor(), update.getPrice()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int updateAuthorByPseudonym(String pseudonym, Author update) {
        return selectAuthorByPseudonym(pseudonym)
                .map(author -> {
                    int indexOfAuthorToUpdate = DBAuthor.indexOf(author);
                    if (indexOfAuthorToUpdate >= 0) {
                        DBAuthor.set(indexOfAuthorToUpdate, new Author(update.getName(), pseudonym));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
