package com.githab.kondyreva.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private Boolean isBlocked;
    private LocalDate expireDate;
    private String cardNumber;
    private String pin;
    private Balance balance;
}
