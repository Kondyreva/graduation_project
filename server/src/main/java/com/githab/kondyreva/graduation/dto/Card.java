package com.githab.kondyreva.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private boolean isBlocked;
    private LocalDate expireDate;
    private int cardNumber;
    private int pin;
    private Balance balance;
}
