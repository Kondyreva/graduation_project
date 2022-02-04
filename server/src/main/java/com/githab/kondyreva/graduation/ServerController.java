package com.githab.kondyreva.graduation;

import com.githab.kondyreva.graduation.service.AtmTransaction;
import com.githab.kondyreva.graduation.service.CardTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {

    @GetMapping("/getinfo")
    public ResponseEntity<String> getInfo() {
        CardTransaction card = new AtmTransaction();

        return new ResponseEntity<>(card.getBalance("123","123"), HttpStatus.OK);
    }
}
