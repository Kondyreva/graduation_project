package com.github.maven.graduation.service;

import com.github.maven.graduation.dto.Card;
import com.github.maven.graduation.repository.CardInfoFromDB;
import com.github.maven.graduation.repository.InfoFromDB;

import java.time.LocalDate;

public class AtmTransaction implements CardTransaction {

    @Override
    public String getBalance(String cardNumber, String pin) {
        InfoFromDB infoFromDB = new CardInfoFromDB();

        Card card = infoFromDB.getCardInfo(cardNumber);
        if (card != null) {
            if (card.getPin().equals(pin)) {
                if (card.getIsBlocked()) {
                    return "Карта заблокирована";
                }
                if (card.getExpireDate().isBefore(LocalDate.now())) {
                    return "Срок действия карты истек";
                }

                return "Баланс вашей карты " + card.getBalance().toString()
                        + " " + card.getCurrency();
            } else return "Введен неверный пин";
        } else return "Карта не найдена";
    }
}
