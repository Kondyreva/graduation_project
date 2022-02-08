package com.githab.kondyreva.graduation.repository;

import com.githab.kondyreva.graduation.enums.Currency;
import com.githab.kondyreva.graduation.dto.Balance;
import com.githab.kondyreva.graduation.dto.Card;

import java.time.LocalDate;

public class CardInfoFromDB implements InfoFromDB {

    @Override
    public Card getCardInfo(int cardNumber) {
        /*TODO: реализовать через БД H2*/
        Card card = new Card(false, LocalDate.ofYearDay(2025, 1), cardNumber,
                123, new Balance(200, Currency.RUB.name()));
        return card;
    }
}
