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
		String name = scanfName();
		menu();
		while (true) {
			String choose = scanfDataUserChoose();
			handleDataUserEntry(choose, name);
		}
	}

	// scanf your name
	public String scanfName(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("What your name?");
		String name=null;
		if (scanner.hasNext()) {
			name = scanner.nextLine();
		}
		System.out.println("Hello "+ name);
		return name;
	}

	// scanf data user entry
	public String scanfDataUserChoose(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Your choose: ");
		String choose=null;
		if (scanner.hasNext()) {
			choose = scanner.nextLine();
		}

		return choose;
	}

	// printf menu
	public void menu(){
		System.out.println("----------MENU----------");
		System.out.println("1. ContainsAny");
		System.out.println("2. ContainsIgnoreCase");
		System.out.println("3. AppendIfMissing");
		System.out.println("4. PrependIfMissing");
		System.out.println("5. CountMatches");
		System.out.println("6. Uppercase");
		System.out.println("7. Lowercase");
		System.out.println("8. Quit");
		System.out.println("------------------------");
	}

	//handle data user entry
	public void handleDataUserEntry(String data, String name){
		int dataNumber = 0;
		try {
			dataNumber  = Integer.parseInt(data);
		}catch (NumberFormatException e){
			invalidDataEntry();
			quit();
		}
		switch (dataNumber){
			case 1:
				containsAnyMethod(name);
				break;
			case 2:
				containsIgnoreCaseMethod(name);
				break;
			case 3:
				appendIfMissingMethod(name);
				break;
			case 4:
				prependIfMissingMethod(name);
				break;
			case 5:
				countMatchesMethod(name);
				break;
			case 6:
				uppercaseMethod(name);
				break;
			case 7:
				lowercaseMethod(name);
				break;
			case 8:
				quit();
				break;
			default:
				invalidDataEntry();
				return;
		}
	}

	//printError
	public void invalidDataEntry(){
		System.out.println("Invalid Data Entry");
	}

	//exit
	public void quit(){
		System.exit(0);
	}

	//
	public void containsAnyMethod(String name){
		String containsAny = "abc";
		System.out.println("containsAny "+ "with " + containsAny + " result is " + StringUtils.containsAny(name, containsAny));
	}

	//
	public void containsIgnoreCaseMethod(String name){
		String containsIgnoreCase = "abc";
		System.out.println("containsIgnoreCase "+ "with " + containsIgnoreCase + " result is " + StringUtils.containsIgnoreCase(name, containsIgnoreCase));
	}

	//
	public void countMatchesMethod(String name){
		String countMatches = "abc";
		System.out.println("countMatches "+ "with " + countMatches + " result is " + StringUtils.countMatches(name, countMatches));
	}

	//
	public void appendIfMissingMethod(String name){
		String appendIfMissing = "abc";
		System.out.println("appendIfMissing "+ "with " + appendIfMissing + " result is " + StringUtils.appendIfMissing(name, appendIfMissing));
	}

	//
	public void prependIfMissingMethod(String name){
		String prependIfMissing = "abc";
		System.out.println("prependIfMissing "+ "with " + prependIfMissing + " result is " + StringUtils.prependIfMissing(name, prependIfMissing));
	}

	//
	public void uppercaseMethod(String name){
		String uppercase = "abc";
		System.out.println("uppercase "+ "with " + uppercase + " result is " + StringUtils.upperCase(name));
	}

	//
	public void lowercaseMethod(String name){
		String lowercase = "abc";
		System.out.println("lowercase "+ "with " + lowercase + " result is " + StringUtils.lowerCase(name));
	}
}
