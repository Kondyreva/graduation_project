package com.githab.kondyreva.graduation;

import com.githab.kondyreva.graduation.service.AtmTransaction;
import com.githab.kondyreva.graduation.service.CardTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/server")
public class ServerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerController.class);

    @PostMapping("/getinfo")
    public ResponseEntity<String> getInfo(@RequestHeader("cardNumber") Integer cardNumber, @RequestHeader("pin") Integer pin) {
        LOGGER.debug("cardNumber=" + cardNumber + ", pin=" + pin);
        CardTransaction card = new AtmTransaction();

        return new ResponseEntity<>(card.getBalance(cardNumber,pin), HttpStatus.OK);
    }
}
