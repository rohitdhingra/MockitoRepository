package com.example.mockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mockito.dao.UserRepository;
import com.example.mockito.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User addUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getUsers() {
		List<User> users = userRepo.findAll();
		System.out.println("Getting data from DB"+users);
		return users;
	}

	public List<User> getUserByAddress(String address) {
		return userRepo.findByAddress(address);
	}

	public void deleteUser(User user) {
		userRepo.delete(user);
	}
}

