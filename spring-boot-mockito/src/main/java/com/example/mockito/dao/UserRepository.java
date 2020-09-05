package com.example.mockito.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mockito.model.User;

public interface UserRepository extends MongoRepository<User,Integer> {
	List<User> findByAddress(String address);

}
