package com.example.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class Book {
    private int id;
    @NotEmpty(message ="Should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String title;
    @NotEmpty(message ="Should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String author;
    @Min(value = 1500, message ="Year should be greater then 1500")
    private String year;

    public Book(){

    }

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
