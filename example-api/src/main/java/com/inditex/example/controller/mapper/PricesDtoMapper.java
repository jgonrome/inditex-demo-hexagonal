package com.inditex.example.controller.mapper;

import org.mapstruct.Mapper;

import com.inditex.example.domain.prices.Prices;
import com.inditex.example.controller.dto.PricesDto;

/**
 * @author Juan Francisco Gonzalez
 * 
 */
@Mapper
public interface PricesDtoMapper {
	PricesDto from(Prices owner);
}
