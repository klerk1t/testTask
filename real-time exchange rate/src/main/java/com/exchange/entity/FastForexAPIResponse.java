package com.exchange.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FastForexAPIResponse{

    @JsonProperty
    private String base;
    @JsonProperty
    private Result result;
    @JsonProperty
    private String updated;
    @JsonProperty
    private String ms;

    @Override
    public String toString() {
        return "FastForexAPIResponse{" +
                "base='" + base + '\'' +
                ", result=" + result +
                ", update=" + updated +
                ", ms='" + ms + '\'' +
                '}';
    }

}
