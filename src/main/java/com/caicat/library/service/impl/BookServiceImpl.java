package com.caicat.library.service.impl;

import com.caicat.library.entity.Book;
import com.caicat.library.mapper.BookMapper;
import com.caicat.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@SuppressWarnings("all")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Override
    public List<Book> getBookAll() {
        return mapper.getBookAll();
    }

    @Override
    public boolean updateBook(Book book) {
        return mapper.updateBook(book)>0;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return mapper.deleteBook(id)>0;
    }

    @Override
    public boolean insertBook(Book book) {
        return mapper.insertBook(book)>0;
    }

    //按id查询书籍
    public Book selectBookById(Integer id){
        return mapper.selectBookById(id);
    }

    public List<Book> selectBookByBody(Book book){
        return mapper.selectBookByBody(book);
    }
}
