package com.sapo.edu.demo;

import com.sapo.edu.demo.entities.User;
import com.sapo.edu.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	UserRepository userRepository;
	PasswordEncoder passwordEncoder;

	public DemoApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(2);
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		userRepository.save(user);
		System.out.println(user);
	}
}
