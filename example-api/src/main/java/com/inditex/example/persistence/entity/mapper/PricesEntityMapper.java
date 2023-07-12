package com.inditex.example.persistence.entity.mapper;

import com.inditex.example.domain.prices.Prices;
import com.inditex.example.persistence.entity.PricesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PricesEntityMapper {
    List<Prices> map(List<PricesEntity> prices);

    Prices from(PricesEntity pricesEntity);

    PricesEntity map(Prices prices);
}
