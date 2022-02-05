package com.github.kondyreva.graduation;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/balance")
public class ClientController {
    private static final String RESOURCE_URL = "http://localhost:8080/server/getinfo";
    private static final String MY_PASSWORD = "123";
    private static final String MY_LOGIN = "admin";

    @GetMapping("/get")
    public ResponseEntity<String> get() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response =
                restTemplate.exchange(RESOURCE_URL, HttpMethod.GET, new HttpEntity<String>(createHeaders(MY_LOGIN, MY_PASSWORD)), String.class);

        if (HttpStatus.OK.equals(response.getStatusCode())) {
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        }

        return new ResponseEntity<>("No balance :-(", HttpStatus.NO_CONTENT);
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
