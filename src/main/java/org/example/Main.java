package org.example;

import org.example.controller.CommandProcessor;
import org.example.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();

        // Hardcoded users (for simplicity)
        processor.addUser(new User("u1", "User1", "u1@example.com", "123"));
        processor.addUser(new User("u2", "User2", "u2@example.com", "456"));
        processor.addUser(new User("u3", "User3", "u3@example.com", "789"));
        processor.addUser(new User("u4", "User4", "u4@example.com", "000"));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            processor.processCommand(input);
        }
    }

//    EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
//    SHOW
//    EXPENSE u1 1250 2 u2 u3 EXACT 370 880
//    SHOW u2
//    EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
//    SHOW
//    exit


}