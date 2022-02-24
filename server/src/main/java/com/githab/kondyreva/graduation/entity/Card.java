package com.githab.kondyreva.graduation.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "card_number",unique = true, nullable = false)
    private int cardNumber;
    @Column (nullable = false)
    private int pin;
    @Column (name = "is_blocked", columnDefinition = "boolean default false")
    private boolean isBlocked;
    @Column (name = "expire_date",nullable = false)
    private LocalDate expireDate;
    @Column (nullable = false, columnDefinition = "double default 0")
    private double amount = 0;
    @Column (nullable = false)
    private String currency;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
