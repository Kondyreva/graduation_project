package com.githab.kondyreva.graduation.repository;

import com.githab.kondyreva.graduation.dto.Card;

public interface InfoFromDB {
    Card getCardInfo(String cardNumber);
}
