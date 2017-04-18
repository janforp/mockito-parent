package com.janita.mock.one.service;

import com.janita.mock.one.bean.Book;

import java.util.Collections;
import java.util.List;

/**
 * Created by Janita on 2017-04-18 19:50
 */
public class BookService {

    private static BookService bookService = new BookService();

    public List<Book> getAllBooks(){
        return Collections.EMPTY_LIST;
    }

    public Book getBook(String isbn){
        return null;
    }

    public String addBook(Book book){
        return book.getIsbn();
    }

    public String updateBook(Book book){
        return book.getIsbn();
    }

    public static BookService getInstance(){
        return bookService;
    }
}
