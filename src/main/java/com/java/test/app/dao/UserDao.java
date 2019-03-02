package com.java.test.app.dao;

import com.java.test.app.models.User;

public interface UserDao {
	void insert(User cus);
	User get(long Id);
}