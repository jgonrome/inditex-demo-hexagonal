package com.inditex.example.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.example.domain.prices.Prices;
import com.inditex.example.domain.prices.PricesRepository;
import com.inditex.example.persistence.entity.mapper.PricesEntityMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import({PricesRepositoryImpl.class, PricesEntityMapperImpl.class})
public class PricesRepositoryTest {
    @Autowired
    PricesRepository pricesRepository;

    @Test
    void shouldFindAll() {
        List<Prices> prices = this.pricesRepository.findAll();
        assertThat(prices).asList().hasSize(4);
    }

    @Test
    void givenParameters_whenGetPrices_thenShouldReturn_PricesList() {
        List<Prices> prices = pricesRepository.getPrices(LocalDateTime.of(2020, 6, 14, 15, 10), 1, 35455);

        assertThat(prices).asList().hasSize(2);
        assertEquals(25.5, prices.get(0).getPrice());
        assertEquals(35.5, prices.get(1).getPrice());
     }

}
