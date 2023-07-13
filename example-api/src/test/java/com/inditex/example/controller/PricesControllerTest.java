package com.inditex.example.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inditex.example.application.PricesService;
import com.inditex.example.controller.mapper.PricesDtoMapperImpl;
import com.inditex.example.domain.prices.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebMvcTest(PricesController.class)
@Import(PricesDtoMapperImpl.class)
public class PricesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService pricesService;

    @Test
    void return_price_when_prices_exists() throws Exception {
        Prices prices = Prices.builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 22, 10, 0))
                .productId(35455)
                .priceList(1)
                .priority((short)1)
                .price(35.5)
                .curr("EUR").build();

        given(this.pricesService.getPrices(LocalDateTime.of(2020, 6, 14, 10, 0), 1, 35455)).willReturn(Optional.of(prices));

        final LocalDateTime day = LocalDateTime.of(2020, 6, 14, 10, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        this.mockMvc
                .perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(35.5)));
    }

    @Test
    void return_not_found_when_prices_does_not_exists() throws Exception {
         given(this.pricesService.getPrices(LocalDateTime.of(2020, 6, 11, 10, 0), 1, 35455)).willReturn(Optional.empty());

        this.mockMvc
                .perform(get("/api/v1/prices")
                        .queryParam("appTime", "2020-06-11T10:00:00")
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
