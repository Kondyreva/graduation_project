package com.github.maven.graduation.keyboard_interface;

import com.github.maven.graduation.service.AtmTransaction;
import com.github.maven.graduation.service.CardTransaction;

import java.util.Scanner;

public class InputOutputBalanceFromConsole implements InputOutputFromConsole {
    @Override
    public void dealingWithBalanceFromConsole() {
        CardTransaction cardTransaction = new AtmTransaction();

        try (Scanner reader = new Scanner(System.in);) {
            System.out.println("Enter card number: ");
            String cardNumber = reader.nextLine();
            System.out.println("Enter pin: ");
            String pin = reader.nextLine();

            if (!cardNumber.isEmpty() && !pin.isEmpty()) {
                System.out.println(cardTransaction.getBalance(cardNumber, pin));
            } else System.out.println("Card number and pin should not be empty! ");
        }
    }
}
