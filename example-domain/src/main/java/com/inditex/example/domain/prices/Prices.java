package com.inditex.example.domain.prices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prices {
     private long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private long priceList;

    private long productId;

    private short priority;

    private double price;

    private String curr;
}
