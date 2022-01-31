package com.githab.kondyreva.graduation.service;

import com.githab.kondyreva.graduation.repository.CardInfoFromDB;
import com.githab.kondyreva.graduation.repository.InfoFromDB;
import com.githab.kondyreva.graduation.dto.Card;

import java.time.LocalDate;

public class AtmTransaction implements CardTransaction {

    @Override
    public String getBalance(String cardNumber, String pin) {
        InfoFromDB infoFromDB = new CardInfoFromDB();

        Card card = infoFromDB.getCardInfo(cardNumber);
        /*TODO поменять на optional!!!*/
        if (card != null) {
            if (card.getPin().equals(pin)) {
                if (card.getIsBlocked()) {
                    return "Карта заблокирована";
                }
                if (card.getExpireDate().isBefore(LocalDate.now())) {
                    return "Срок действия карты истек";
                }

                return "Баланс вашей карты " + card.getBalance().getBalance()
                        + " " + card.getBalance().getCurrency();
            } else return "Введен неверный пин";
        } else return "Карта не найдена";
    }
}
