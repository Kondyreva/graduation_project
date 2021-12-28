package com.github.maven.graduation;

import com.github.maven.graduation.keyboard_interface.InputOutputBalanceFromConsole;
import com.github.maven.graduation.keyboard_interface.InputOutputFromConsole;

public class Main {

    public static void main(String[] args) {
        InputOutputFromConsole inputOutputFromConsole = new InputOutputBalanceFromConsole();
        inputOutputFromConsole.dealingWithBalanceFromConsole();
    }
}
