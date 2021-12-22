package com.caicat.library.service;

import com.caicat.library.entity.Book;

import java.util.List;

public interface BookService {
    //查所有
     List<Book> getBookAll();

     boolean updateBook(Book book);

     boolean deleteBook(Integer id);

     boolean insertBook(Book book);

    Book selectBookById(Integer id);

    List<Book> selectBookByBody(Book book);
}
