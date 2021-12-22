package com.caicat.library.mapper;

import com.caicat.library.entity.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getBookAll();

    int insertBook(Book book);

    int updateBook(Book book);

    int deleteBook(Integer id);

    Book selectBookById(Integer id);

    List<Book> selectBookByBody(Book book);
}
