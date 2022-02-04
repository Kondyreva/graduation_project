package com.github.kondyreva.graduation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/balance")
public class ClientController {

    @GetMapping("/get")
    public ResponseEntity<String> get(/*@RequestBody CardInputData request*/) {


       /*  String pin = request.getPin();
           String cardNumber = request.getCardNumber();*/
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8080/server/getinfo";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);

        if (HttpStatus.OK.equals(response.getStatusCode())) {
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        }

        return new ResponseEntity<>("No balance :-(", HttpStatus.NO_CONTENT);
    }
}
