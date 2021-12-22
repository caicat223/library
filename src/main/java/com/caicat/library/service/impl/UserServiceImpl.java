package com.caicat.library.service.impl;

import com.caicat.library.entity.User;
import com.caicat.library.mapper.UserMapper;
import com.caicat.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User Login(User user) {
        User login = mapper.Login(user);
        if(login!=null){
            return login;
        }else{
            throw new RuntimeException("认证失败");
        }
    }

    @Override
    public List<User> getBookAll() {
        return null;
    }

    @Override
    public boolean updateBook(User book) {
        return false;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return false;
    }

    @Override
    public boolean insertBook(User book) {
        return false;
    }

    @Override
    public User selectBookById(Integer id) {
        return null;
    }

    @Override
    public List<User> selectBookByBody(User book) {
        return null;
    }
}
