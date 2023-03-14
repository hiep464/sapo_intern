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

//		System.out.println("Hello word");

		System.out.println("What your name?");
		String name=null;
		if (scanner.hasNext()) {
			name = scanner.nextLine();
		}
		System.out.println("Hello "+ name);
		String containsAny = "abc";
		System.out.println("containsAny "+ "with " + containsAny + "result is " + StringUtils.containsAny(name, containsAny));

		String containsIgnoreCase = "abc";
		System.out.println("containsAny "+ "with " + containsIgnoreCase + "result is " + StringUtils.containsIgnoreCase(name, containsIgnoreCase));

		String countMatches = "abc";
		System.out.println("countMatches "+ "with " + countMatches + "result is " + StringUtils.countMatches(name, countMatches));

		String appendIfMissing = "abc";
		System.out.println("appendIfMissing "+ "with " + appendIfMissing + "result is " + StringUtils.appendIfMissing(name, appendIfMissing));

		String prependIfMissing = "abc";
		System.out.println("prependIfMissing "+ "with " + prependIfMissing + "result is " + StringUtils.prependIfMissing(name, prependIfMissing));

		String uppercase = "abc";
		System.out.println("countMatches "+ "with " + uppercase + "result is " + StringUtils.upperCase(name));

		String lowercase = "abc";
		System.out.println("lowercase "+ "with " + lowercase + "result is " + StringUtils.lowerCase(name));
	}
}
