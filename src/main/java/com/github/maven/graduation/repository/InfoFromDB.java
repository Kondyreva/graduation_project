package com.github.maven.graduation.repository;

import com.github.maven.graduation.dto.Card;

public interface InfoFromDB {
    Card getCardInfo(String cardNumber);
}
