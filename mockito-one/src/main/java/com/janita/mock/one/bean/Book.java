package com.janita.mock.one.bean;

import lombok.Data;

import java.util.List;

/**
 * Created by Janita on 2017-04-18 19:48
 */
@Data
public class Book {

    private String isbn;
    private String title;
    private List<String> authors;
    private String publication;
    private Integer yearOfPublication;
    private Integer numberOfPages;
    private String image;


    public Book(String isbn, String title, List<String> authors,
                String publication, Integer yearOfPublication, Integer numberOfPages,
                String image) {

        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publication = publication;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.image = image;

    }
}
