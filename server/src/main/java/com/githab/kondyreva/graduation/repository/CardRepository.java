package com.githab.kondyreva.graduation.repository;

import com.githab.kondyreva.graduation.entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
    Card getCardByCardNumber(int cardNumber);
}
