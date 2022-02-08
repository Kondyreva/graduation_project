package com.github.kondyreva.graduation;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/balance")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
    private static final String RESOURCE_URL = "http://localhost:8080/server/getinfo";
    private static final String MY_PASSWORD = "123";
    private static final String MY_LOGIN = "admin";

    @GetMapping("/card_number/{cardNumber}/pin/{pin}")
    public ResponseEntity<String> get(@PathVariable("cardNumber") int cardNumber,
                                      @PathVariable("pin") int pin) {
        LOGGER.debug("card_number " + cardNumber + " pin " + pin);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders requestHeaders = createHeaders(MY_LOGIN, MY_PASSWORD); /*new HttpEntity<String>(createHeaders(MY_LOGIN, MY_PASSWORD))*/
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("cardNumber", String.valueOf(cardNumber));
        requestHeaders.set("pin", String.valueOf(pin));

        LOGGER.debug(requestHeaders.toString());

        HttpEntity<String> httpEntity = new HttpEntity<>("params", requestHeaders);

        ResponseEntity<String> response =
                restTemplate.exchange(RESOURCE_URL, HttpMethod.POST, httpEntity, String.class);

        if (HttpStatus.OK.equals(response.getStatusCode())) {
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        }

        return new ResponseEntity<>("No money - no honey :-(", HttpStatus.NO_CONTENT);
    }

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}
