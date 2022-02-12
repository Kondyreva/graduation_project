package com.githab.kondyreva.graduation.repository;

import com.githab.kondyreva.graduation.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public String getCardByNumber(int cardNumber, int pin){
        Optional<Card> card = Optional.ofNullable(cardRepository.getCardByCardNumber(cardNumber));
        if (card.isPresent()) {
            if (card.get().getPin() == pin) {
                if (card.get().isBlocked()) {
                    return "Карта заблокирована";
                }
                if (card.get().getExpireDate().isBefore(LocalDate.now())) {
                    return "Срок действия карты истек";
                }
                return "Баланс вашей карты " + card.get().getAmount()
                        + " " + card.get().getCurrency();
            } else return "Введен неверный пин";
        } else return "Карта не найдена";
    }
}
