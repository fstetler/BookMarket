package com.example.demo.dao;

import com.example.demo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class AuthorDataAccessService implements AuthorDao {

    private static List<Author> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Author author) {
        DB.add(new Author(id, author.getName()));
        return 1;
    }

    @Override
    public List<Author> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Author> selectPersonById(UUID id) {
        return DB.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Author> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Author update) {
        return selectPersonById(id)
                .map(author -> {
                    int indexOfPersonToUpdate = DB.indexOf(author);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Author(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
