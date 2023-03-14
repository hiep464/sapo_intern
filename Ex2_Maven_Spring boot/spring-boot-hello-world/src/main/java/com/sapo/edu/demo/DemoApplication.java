package com.sapo.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("What your name?");
		String name=null;
		if (scanner.hasNext()) {
			name = scanner.nextLine();
		}
		String containsAny = "abc";
		System.out.println("Hello "+ name);
		System.out.println("containsAny "+ StringUtils.containsAny(name, containsAny));
	}
}
