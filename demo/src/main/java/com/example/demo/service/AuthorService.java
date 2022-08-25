package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorDao personDao;

    // autowired forces the personService should be instantiated and injected into the constructor
    @Autowired
    public AuthorService(@Qualifier("fakeDao") AuthorDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Author author) {
        return personDao.insertPerson(author);
    }

    public List<Author> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Author> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Author newAuthor) {
        return personDao.updatePersonById(id, newAuthor);
    }
}
