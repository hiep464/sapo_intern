package com.sapo.edu.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PrinterFile implements Printer {
    @Override
    public void printCustoner(Customer customer) {
        Log.info("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        Log.info(message);
    }
}
