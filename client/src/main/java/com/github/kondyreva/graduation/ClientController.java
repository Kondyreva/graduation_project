package com.github.kondyreva.graduation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class ClientController {
    private final String sharedKey = "123";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @PostMapping("/get")
    public BalanceReturn get(@RequestParam(value = "key") String key, @RequestBody CardInputData request) {

        BalanceReturn response;

        if (sharedKey.equalsIgnoreCase(key)) {
            String pin = request.getPin();
            String cardNumber = request.getCardNumber();
            // Process the request
            // ....
            // Return success response to the client.
            response = new BalanceReturn(200.0,"USD");
        } else {
            response = new BalanceReturn();
        }
        return response;
    }
}
