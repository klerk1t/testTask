package com.exchange.service;

import com.exchange.entity.CurrencyRate;
import com.exchange.entity.Response;
import com.exchange.repository.CurrencyRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyRateService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public Response prepareResponse(CurrencyRate cr) {
        saveCurrencyRate(cr);
        BigDecimal averageRate = currencyRateRepository.findAverageRateByDate();
        return new Response(cr.getRate(), averageRate, new Date());
    }

    private void saveCurrencyRate(CurrencyRate cr) {
        currencyRateRepository.save(cr);
    }

}
