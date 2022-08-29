package com.example.demo.dao;

import com.example.demo.model.Author;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Author
 */
public interface AuthorDao {

    int insertAuthor(Author author);

    default int addAuthor(Author author) {
        return insertAuthor(author);
    }

    List<Author> selectAllAuthors();

    Optional<Author> selectAuthorByPseudonym(String pseudonym);

    int deleteAuthorByPseudonym(String pseudonym);

    int updateAuthorByPseudonym(String pseudonym, Author author);

}
