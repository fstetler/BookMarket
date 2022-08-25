package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(@Qualifier("dao") AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public int addAuthor(Author author) {
        return authorDao.insertAuthor(author);
    }

    public List<Author> getAllAuthors() {
        return authorDao.selectAllAuthors();
    }

    public Optional<Author> getAuthorByPseudonym(String pseudynom) {
        return authorDao.selectAuthorByPseudonym(pseudynom);
    }


}
