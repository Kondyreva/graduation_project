package com.github.kondyreva.graduation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CardInputData {
    private String cardNumber;
    private String pin;
}
