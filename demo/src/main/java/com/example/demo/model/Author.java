package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Author {

    private final String name;
    private final String pseudonym;

    public Author(@JsonProperty("name") String name, @JsonProperty("pseudonym") String pseudonym) {
        this.name = name;
        this.pseudonym = pseudonym;
    }

    public String getName() {
        return name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", pseudonym='" + pseudonym + '\'' +
                '}';
    }
}
