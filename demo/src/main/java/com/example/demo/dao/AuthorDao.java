package com.example.demo.dao;

import com.example.demo.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDao {

    int insertPerson(UUID id, Author author);

    default int insertPerson(Author author) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, author);
    }

    List<Author> selectAllPeople();

    Optional<Author> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Author author);



}
