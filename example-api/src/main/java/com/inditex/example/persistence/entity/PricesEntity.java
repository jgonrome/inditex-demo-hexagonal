package com.inditex.example.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Juan Francisco Gonzalez
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
@IdClass(PricesEntityId.class)
@Builder
public class PricesEntity implements Serializable {
	private static final long serialVersionUID = -7933490826392014404L;

    @Id
    @Column(name = "BRAND_ID")
    private long brandId;

    @Id
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Id
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private long priceList;

    @Id
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Id
    @Column(name = "PRIORITY")
    private short priority;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CURR")
    private String curr;

}
