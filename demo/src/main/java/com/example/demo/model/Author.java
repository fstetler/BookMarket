package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Author properties and variables
 */
public class Author {

    private final String name;
    private final String pseudonym;

    public Author(@JsonProperty("name") String name,
                  @JsonProperty("pseudonym") String pseudonym) {
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
