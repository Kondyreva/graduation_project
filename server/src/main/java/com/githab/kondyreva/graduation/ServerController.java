package com.githab.kondyreva.graduation;

import com.githab.kondyreva.graduation.repository.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/server")
public class ServerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerController.class);

    @Autowired
    CardService cardService;

    @PostMapping("/getbalance")
    public ResponseEntity<String> getInfo(@RequestHeader("cardNumber") int cardNumber, @RequestHeader("pin") int pin) {
        LOGGER.debug("cardNumber=" + cardNumber + ", pin=" + pin);

        return new ResponseEntity<>(cardService.getCardByNumber(cardNumber, pin), HttpStatus.OK);
    }
}
