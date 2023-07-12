package com.inditex.example.domain.prices;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author Juan Francisco Gonzalez
 * 
 */
public interface PricesRepository {

	List<Prices> getPrices(LocalDateTime appTime, long brandId, long productId);

}
