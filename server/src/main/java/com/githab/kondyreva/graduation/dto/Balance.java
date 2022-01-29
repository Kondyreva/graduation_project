package com.githab.kondyreva.graduation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@AllArgsConstructor
@Value
public class Balance {
    double balance;
    String currency;
}
