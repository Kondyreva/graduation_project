package com.githab.kondyreva.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Value
public class Card {
    Boolean isBlocked;
    LocalDate expireDate;
    String cardNumber;
    String pin;
    Balance balance;
}
