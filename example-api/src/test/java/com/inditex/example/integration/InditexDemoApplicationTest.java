package com.inditex.example.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class InditexDemoApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPrices_at_10_of_Day14_Product_35455_Brand_1() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 14, 10, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price", is(35.5)));
    }

    @Test
    void testPrices_at_16_of_Day14_Product_35455_Brand_1() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 14, 16, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price", is(25.5)));
    }

    @Test
    void testPrices_at_21_of_Day14_Product_35455_Brand_1() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 14, 21, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price", is(35.5)));
    }

    @Test
    void testPrices_at_10_of_Day15_Product_35455_Brand_1() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 15, 10, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price", is(30.5)));
    }
    @Test
    void testPrices_at_21_of_Day16_Product_35455_Brand_1() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 16, 21, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.price", is(38.95)));
    }
    @Test
    void testPrices_at_10_of_Day11_Product_35455_Brand_1_ShouldReturn_404() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 11, 10, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "1")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_PROBLEM_JSON))
                .andExpect(jsonPath("$.detail", containsString("Price Not Found")));
    }

    @Test
    void testPrices_at_10_of_Day14_Product_35455_Brand_0_ShouldReturn_400() throws Exception {
        final LocalDateTime day = LocalDateTime.of(2020, 6, 11, 10, 0);
        final String dayStr = day.format(DateTimeFormatter.ISO_DATE_TIME);

        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", dayStr)
                        .queryParam("brandId", "0")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenPrices_whenGetPrices_NotValidDate_thenStatus400() throws Exception {
        mockMvc.perform(get("/api/v1/prices")
                        .queryParam("appTime", "2020-06-11T30:30:00")
                        .queryParam("brandId", "0")
                        .queryParam("productId", "35455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_PROBLEM_JSON))
                .andExpect(jsonPath("$.detail", containsString("Failed to convert")));
    }

}
