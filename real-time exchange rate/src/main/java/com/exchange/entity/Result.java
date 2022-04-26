package com.exchange.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Result {

    @JsonProperty
    private BigDecimal UAH;

    @Override
    public String toString() {
        return "Result{" +
                "UAH='" + UAH + '\'' +
                '}';
    }

}
