package com.inditex.example.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.inditex.example.domain.prices.Prices;
import com.inditex.example.domain.prices.PricesRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Juan Francisco Gonzalez
 *
 */
@RequiredArgsConstructor
public class PricesService { 
	
	private final PricesRepository pricesRepository;

    public Optional<Prices> getPrices(LocalDateTime appTime, long brandId, long productId)  {

		List<Prices> pricesEntity = pricesRepository.getPrices(appTime, brandId, productId);

    	return pricesEntity.stream().findFirst();
     }

}
