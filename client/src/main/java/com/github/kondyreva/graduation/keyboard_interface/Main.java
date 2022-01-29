package com.github.kondyreva.graduation.keyboard_interface;

import com.github.kondyreva.graduation.keyboard_interface.InputOutputFromConsole;
import com.github.kondyreva.graduation.keyboard_interface.InputOutputBalanceFromConsole;

public class Main {

    public static void main(String[] args) {
        InputOutputFromConsole inputOutputFromConsole = new InputOutputBalanceFromConsole();
        inputOutputFromConsole.dealingWithBalanceFromConsole();
    }
}
