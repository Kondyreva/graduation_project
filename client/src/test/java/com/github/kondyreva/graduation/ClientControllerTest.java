package com.github.kondyreva.graduation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ClientController client ;

    @Test
    void getBalanceFromServerTest() {
        String expected = "Игорь, баланс вашей карты 777 RUB";

        when(restTemplate.exchange(ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<String>>any()))
                .thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        ResponseEntity<String> result = client.getBalanceFromServer(123, 123);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(result.getBody(), equalTo(expected));
    }

}

