package com.githab.kondyreva.graduation.repository;

import com.githab.kondyreva.graduation.dto.Card;

import java.time.LocalDate;

public class CardInfoFromDB implements InfoFromDB {

    @Override
    public Card getCardInfo(String cardNumber) {
        /*TODO: реализовать через БД H2*/
        Card card = new Card(false, LocalDate.ofYearDay(2025, 1), "123",
                "123", 200.00, "rub");
        return card;
    }
}
