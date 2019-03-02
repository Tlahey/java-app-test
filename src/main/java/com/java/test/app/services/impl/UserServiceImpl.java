package com.java.test.app.services.impl;

import com.java.test.app.dao.UserDao;
import com.java.test.app.models.User;
import com.java.test.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserDao userDao;

    @Override
    public void insert(User cus) {
        userDao.insert(cus);
    }

    @Override
    public User get(Long id) {
        // TODO: mettre le rowMapper ici pour split service et Dao
        return userDao.get(id);
    }

}