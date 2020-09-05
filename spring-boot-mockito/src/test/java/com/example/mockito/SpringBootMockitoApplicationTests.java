package com.example.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mockito.dao.UserRepository;
import com.example.mockito.model.User;
import com.example.mockito.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootMockitoApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getUsersTest() {
		when(repository.findAll())
				.thenReturn( Stream.of(new User(1, "Rohit", 34, "Noida"), new User(2, "Anchal", 34, "Noida"))
						.collect(Collectors.toList()));
		assertEquals(2,service.getUsers().size());
	}
}
