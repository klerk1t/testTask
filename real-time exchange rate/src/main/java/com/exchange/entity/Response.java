package com.exchange.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class Response {

    @JsonProperty
    private BigDecimal currentRate;
    @JsonProperty
    private BigDecimal averageRate;
    @JsonProperty
    private Date currentDate;

    @Override
    public String toString() {
        return "[ Current rate: " +
                currentRate +
                " Average rate: " +
                averageRate +
                " Date: " + new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(currentDate) +
                " ]";
    }

}
