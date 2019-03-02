package com.java.test.app.services;

import com.java.test.app.models.User;

public interface UserService {
	void insert(User cus);
	User get(Long id);
}
