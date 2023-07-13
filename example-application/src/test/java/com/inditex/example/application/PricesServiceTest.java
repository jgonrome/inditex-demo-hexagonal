package com.inditex.example.application;

import com.inditex.example.domain.prices.Prices;
import com.inditex.example.domain.prices.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesServiceTest {
    @Mock
    PricesRepository pricesRepository;

    PricesService pricesService;

    @BeforeEach
    void setUp() {
        pricesService = new PricesService(pricesRepository);
    }

    @Test
    void return_prices_list() {
        Prices price1 = Prices.builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 23, 0))
                .productId(35455)
                .priceList(1)
                .priority((short)1)
                .price(35.5)
                .curr("EUR").build();
        Prices price2 = Prices.builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 12, 0))
                .endDate(LocalDateTime.of(2020, 6, 22, 15, 0))
                .productId(35455)
                .priceList(2)
                .priority((short)2)
                .price(25.5)
                .curr("EUR").build();

        when(pricesRepository.getPrices(LocalDateTime.of(2020, 6, 14, 10, 10), 1, 35455)).thenReturn(List.of(price1, price2));

        Optional<Prices> price = pricesService.getPrices(LocalDateTime.of(2020, 6, 14, 10, 10), 1, 35455);

        assertTrue(price.isPresent());
        assertThat(price.get()).isEqualTo(price1);
    }

}
