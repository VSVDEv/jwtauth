package com.example.jwtauth;

import com.example.jwtauth.model.User;
import com.example.jwtauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.persistence.Access;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtauthApplication {

	private final UserRepository repository;
@Autowired
	public JwtauthApplication(UserRepository repository) {
		this.repository = repository;
	}

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "vsvdev", "pass", "vsvdev@mail.com"),
				new User(102, "user1", "pass", "user1@mail.com"),
				new User(103, "user2", "pass", "user2@mail.com"),
				new User(104, "user3", "pass", "user3@mail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}


	public static void main(String[] args) {
		SpringApplication.run(JwtauthApplication.class, args);
	}

}
