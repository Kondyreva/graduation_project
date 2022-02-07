package com.githab.kondyreva.graduation;

import com.githab.kondyreva.graduation.service.AtmTransaction;
import com.githab.kondyreva.graduation.service.CardTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/server")
@Log
public class ServerController {

    @PostMapping("/getinfo")
    public ResponseEntity<String> getInfo(@RequestHeader("cardNumber") Integer cardNumber, @RequestHeader("pin") Integer pin) {
        log.info("cardNumber=" + cardNumber.toString() + ", pin=" + pin);
        CardTransaction card = new AtmTransaction();

        return new ResponseEntity<>(card.getBalance("123","123"), HttpStatus.OK);
    }
}
