package com.inditex.example.controller.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PricesDto implements Serializable {
	@Serial
    private static final long serialVersionUID = 5109253613844894433L;

    @Schema(
        description = "Brand in Group of Stores",
        name = "brandId",
        type = "long")
    long brandId;

    @Schema(
            description = "Start Date for vality of price. ISO-8601 notation",
            name = "startDate",
            type = "LocalDateTime")
    LocalDateTime startDate;

    @Schema(
            description = "End Date for vality of price. ISO-8601 notation",
            name = "endDate",
            type = "LocalDateTime")
    LocalDateTime endDate;

    @Schema(
            description = "Id of applicable prices fare",
            name = "priceList",
            type = "long")
    long priceList;

    @Schema(
            description = "Id of Product",
            name = "productId",
            type = "long")
    long productId;

    @Schema(
            description = "Product price in this range of time, brand and taking account of priority in case of more than one instant valid prices",
            name = "price",
            type = "double")
    double price;
}
