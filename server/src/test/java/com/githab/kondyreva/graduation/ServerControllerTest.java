package com.githab.kondyreva.graduation;

import com.githab.kondyreva.graduation.repository.CardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(ServerController.class)
class ServerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CardService cardService;

    @Test
    @WithMockUser(username="admin",roles={"ADMIN"})
    void getInfo() throws Exception {
        String expected = "Уважаемый Иван, баланс вашей карты 200.2 RUB";
        Mockito.when(cardService.getCardByNumber(123,123)).thenReturn(expected);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/server/getbalance")
                        .header("cardNumber","123")
                        .header("pin","123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultDOW = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
        assertNotNull(resultDOW);
        assertEquals(expected, resultDOW);
    }
}

