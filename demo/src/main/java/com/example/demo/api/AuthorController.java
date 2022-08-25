package com.example.demo.api;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Author author) {
        authorService.addPerson(author);
    }

    @GetMapping
    public List<Author> getAllPeople() {
        return authorService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Author getPersonById(@PathVariable("id") UUID id) {
        return authorService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        authorService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Author authorToUpdate) {
        authorService.updatePerson(id, authorToUpdate);
    }
}
