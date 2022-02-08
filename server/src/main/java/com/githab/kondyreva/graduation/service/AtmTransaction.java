package com.githab.kondyreva.graduation.service;

import com.githab.kondyreva.graduation.repository.CardInfoFromDB;
import com.githab.kondyreva.graduation.repository.InfoFromDB;
import com.githab.kondyreva.graduation.dto.Card;

import java.time.LocalDate;
import java.util.Optional;

public class AtmTransaction implements CardTransaction {

    @Override
    public String getBalance(int cardNumber, int pin) {
        InfoFromDB infoFromDB = new CardInfoFromDB();

        Optional<Card> card = Optional.ofNullable(infoFromDB.getCardInfo(cardNumber));
        if (card.isPresent()) {
            if (card.get().getPin() == pin) {
                if (card.get().isBlocked()) {
                    return "Карта заблокирована";
                }
                if (card.get().getExpireDate().isBefore(LocalDate.now())) {
                    return "Срок действия карты истек";
                }

                return "Баланс вашей карты " + card.get().getBalance().getBalance()
                        + " " + card.get().getBalance().getCurrency();
            } else return "Введен неверный пин";
        } else return "Карта не найдена";
    }
}
