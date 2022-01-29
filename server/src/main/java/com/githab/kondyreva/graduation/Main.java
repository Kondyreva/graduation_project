package com.githab.kondyreva.graduation;

import com.githab.kondyreva.graduation.keyboard_interface.InputOutputFromConsole;
import com.githab.kondyreva.graduation.keyboard_interface.InputOutputBalanceFromConsole;

public class Main {

    public static void main(String[] args) {
        InputOutputFromConsole inputOutputFromConsole = new InputOutputBalanceFromConsole();
        inputOutputFromConsole.dealingWithBalanceFromConsole();
    }
}
