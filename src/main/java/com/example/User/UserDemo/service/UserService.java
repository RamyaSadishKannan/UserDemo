package com.example.User.UserDemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.User.UserDemo.model.dto.User;

@Component
public class UserService {

	public static List<User> userList = new ArrayList<>();

	static {
		userList.add(new User(1, "aaa", new Date()));
		userList.add(new User(2, "bbb", new Date()));
		userList.add(new User(3, "ccc", new Date()));
	}

	public List<User> getAllUser() {
		return userList;
	}

	public User findUserById(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

	public User addNewUser(User user) {

		userList.add(user);
		return user;
	}

	public User deleteUser(int id) {
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
