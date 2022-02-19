package com.githab.kondyreva.graduation.repository;

import com.githab.kondyreva.graduation.ServerApplication;
import com.githab.kondyreva.graduation.entity.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServerApplication.class)
@SpringBootTest
class CardServiceTest {
    @Autowired
    CardService cardService;

    @Test
    void getCardByNumber_success_balance() {
        int cardNumber = 123;
        int pin = 123;

        assertEquals("Уважаемый Иван, баланс вашей карты 200.2 RUB",cardService.getCardByNumber(cardNumber,pin));
    }

    @Test
    void getCardByNumber_is_blocked() {
        int cardNumber = 222;
        int pin = 222;

        assertEquals("Уважаемый Петр, ваша карта заблокирована",cardService.getCardByNumber(cardNumber,pin));
    }

    @Test
    void getCardByNumber_out_of_date() {
        int cardNumber = 111;
        int pin = 111;

        assertEquals("Уважаемый Сидор, срок действия вашей карты истек",cardService.getCardByNumber(cardNumber,pin));
    }

    @Test
    void getCardByNumber_wrong_pin() {
        int cardNumber = 111;
        int pin = 333;

        assertEquals("Введен неверный пин",cardService.getCardByNumber(cardNumber,pin));
    }

    @Test
    void getCardByNumber_card_not_found() {
        int cardNumber = 123456;
        int pin = 333;

        assertEquals("Карта не найдена",cardService.getCardByNumber(cardNumber,pin));
    }
}