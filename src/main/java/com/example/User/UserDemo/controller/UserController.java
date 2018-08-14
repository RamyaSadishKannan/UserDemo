package com.example.User.UserDemo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.User.UserDemo.exception.UserNotFoundException;
import com.example.User.UserDemo.model.dto.User;
import com.example.User.UserDemo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/users/{id}")
	public User findUser(@PathVariable int id) {
		User user = userService.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("User id not found " + id);
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {

		User createdUser = userService.addNewUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("User id not found " + id);
		}

	}

}
