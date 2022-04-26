package com.exchange.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "currency_rate")
public class CurrencyRate {

    public CurrencyRate(BigDecimal rate, LocalDate date) {
        this.rate = rate;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "date")
    private LocalDate date;

}