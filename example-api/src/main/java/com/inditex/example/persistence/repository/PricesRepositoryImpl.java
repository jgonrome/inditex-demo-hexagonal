package com.inditex.example.persistence.repository;

import com.inditex.example.domain.prices.Prices;
import com.inditex.example.domain.prices.PricesRepository;
import com.inditex.example.persistence.entity.mapper.PricesEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PricesRepositoryImpl implements PricesRepository {
    private final PricesJpaRepository jpaRepository;

    private final PricesEntityMapper mapper;

    public List<Prices> findAll() {
        return mapper.map(jpaRepository.findAll());
    }

    @Override
    public List<Prices> getPrices(LocalDateTime appTime, long brandId, long productId) {
        return mapper.map(jpaRepository.getPrices(appTime, brandId, productId));
    }

}
