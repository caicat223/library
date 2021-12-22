package com.caicat.library.service;


import com.caicat.library.entity.User;

import java.util.List;

public interface UserService {
    //登录
    User Login(User user);

    //查所有
    List<User> getBookAll();

    boolean updateBook(User book);

    boolean deleteBook(Integer id);

    boolean insertBook(User book);

    User selectBookById(Integer id);

    List<User> selectBookByBody(User book);
}
