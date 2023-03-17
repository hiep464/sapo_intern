package com.sapo.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Customer customer = new Customer("ABC", "1234", new BigDecimal(5000000));
        Customer customer = createCustomer();
        printfMenu();
        Atm bidvAtm = context.getBean(BidvAtm.class);
        String request = null;
        while (true){
            request = userRequest();
            handlerUserRequest(request, customer, bidvAtm);
            bidvAtm.printCurrentMoney();
        }
    }

    public Customer createCustomer(){
        System.out.print("Name : ");
        Scanner scanner = new Scanner(System.in);
        String name = null;
        if (scanner.hasNext()) {
            name = scanner.nextLine();
        }
        System.out.print("Pin : ");
        String pin = null;
        if (scanner.hasNext()) {
            pin = scanner.nextLine();
        }
        System.out.print("Balance : ");
        String balance = null;
        if (scanner.hasNext()) {
            balance = scanner.nextLine();
        }

        return new Customer(name, pin, new BigDecimal(balance));
    }

    void printfMenu(){
        System.out.println("----------Menu----------");
        System.out.println("1. Print Customer Info");
        System.out.println("2. WithDraw");
        System.out.println("3. Deposit");
        System.out.println("4. Quit");
        System.out.println("------------------------");
    }

    String userRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choose: ");
        String choose = null;
        if (scanner.hasNext()) {
            choose = scanner.nextLine();
        }
        return choose;
    }

    void handlerUserRequest(String request, Customer customer, Atm atm){
        int res = Integer.parseInt(request);
        switch (res){
            case 1:
                printCustomerInfo(customer, atm);
                break;
            case 2:
                withDraw(customer, atm);
                break;
            case 3:
                deposit(customer, atm);
                break;
            case 4:
                quit();
                break;
            default:
                invalidRequest();
                break;
        }
    }

    void quit(){
        System.exit(0);
    }

    void invalidRequest(){
        System.out.println("InvalidChoose");
    }

    void printCustomerInfo(Customer customer, Atm atm){
        atm.displayCustomerInfo(customer);
    }

    void withDraw(Customer customer, Atm atm){
        atm.withDraw(customer, new BigDecimal(200000));
    }

    void deposit(Customer customer, Atm atm){
        atm.deposit(customer, new BigDecimal(200000));
    }
}
