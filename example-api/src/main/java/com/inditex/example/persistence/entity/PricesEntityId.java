package com.inditex.example.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PricesEntityId implements Serializable {
	private static final long serialVersionUID = -4436496361411556368L;

    private long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private long productId;

    private short priority;

}
