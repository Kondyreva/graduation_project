package com.githab.kondyreva.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id
    private int id;
    private int cardNumber;
    private int pin;
    private boolean isBlocked;
    private LocalDate expireDate;
    private double amount;
    private String currency;

}
