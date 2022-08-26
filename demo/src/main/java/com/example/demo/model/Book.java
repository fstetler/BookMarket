package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private final String title;
    private final String description;
    private final String author;
    private final Integer price;

    public Book(@JsonProperty("title") String title, @JsonProperty("description") String description,
                @JsonProperty("author") String author, @JsonProperty("price") Integer price) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
