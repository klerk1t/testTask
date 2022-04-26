package com.exchange.service;

import com.exchange.entity.CurrencyRate;
import com.exchange.entity.FastForexAPIResponse;
import com.exchange.entity.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class CurrencyAPIRequestService {

    @Value("${api.url}")
    private String forexUrl;

    private final CurrencyRateService currencyRateService;
    private final RestTemplate restTemplate;

    public CurrencyAPIRequestService(CurrencyRateService currencyRateService, RestTemplate restTemplate) {
        this.currencyRateService = currencyRateService;
        this.restTemplate = restTemplate;
    }

    public Response requestForex() {
        ResponseEntity<FastForexAPIResponse> response = restTemplate.getForEntity(forexUrl, FastForexAPIResponse.class);
        CurrencyRate cr = new CurrencyRate(response.getBody().getResult().getUAH(), LocalDate.now());
        return currencyRateService.prepareResponse(cr);
    }


}
