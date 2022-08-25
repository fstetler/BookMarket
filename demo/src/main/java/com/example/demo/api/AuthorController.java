package com.example.demo.api;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("author")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "{pseudonym}")
    public Author getAuthorByPseudonym(@PathVariable("pseudonym") String pseudonym) {
        return authorService.getAuthorByPseudonym(pseudonym).orElse(null);
    }

    @DeleteMapping(path = "{pseudonym}")
    public void deleteAuthorByPseudonym(@PathVariable("pseudonym") String pseudonym) {
        authorService.deleteAuthorByPseudonym(pseudonym);
    }

    @PutMapping(path = "{pseudonym}")
    public void updateAuthorByPseudonym(@PathVariable("pseudonym") String pseudonym, @RequestBody Author author) {
        authorService.updateAuthorByPseudonym(pseudonym, author);
    }

}
