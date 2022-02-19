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
    private final static String PREFIX = "Уважаемый ";

    public String getCardByNumber(int cardNumber, int pin) {
        StringBuilder rezult = new StringBuilder();
        Optional<Card> card = Optional.ofNullable(cardRepository.getCardByCardNumber(cardNumber));
        if (card.isPresent()) {
            if (card.get().getPin() == pin) {
                rezult.append(PREFIX)
                        .append(card.get().getClient().getFirstName())
                        .append(",");
                if (card.get().isBlocked()) {
                    rezult.append(" ваша карта заблокирована");
                } else if (card.get().getExpireDate().isBefore(LocalDate.now())) {
                    rezult.append(" срок действия вашей карты истек");
                } else {
                    rezult.append(" баланс вашей карты ")
                            .append(card.get().getAmount())
                            .append(" ")
                            .append(card.get().getCurrency());
                }
            } else rezult.append("Введен неверный пин");
        } else rezult.append("Карта не найдена");
        return rezult.toString();
    }
}
