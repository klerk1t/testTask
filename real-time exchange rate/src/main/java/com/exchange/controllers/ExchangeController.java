package com.exchange.controllers;

import com.exchange.service.CurrencyAPIRequestService;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;


@RestController
public class ExchangeController {

    private final CurrencyAPIRequestService currencyAPIRequestService;

    public ExchangeController(CurrencyAPIRequestService currencyAPIRequestService) {
        this.currencyAPIRequestService = currencyAPIRequestService;
    }

    @RequestMapping(value = "/api/rate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<ServerSentEvent<String>> showExchangeRate() {
        return Flux.interval(Duration.ofSeconds(30))
                .map(sequence -> ServerSentEvent.<String> builder()
                        .data(currencyAPIRequestService.requestForex().toString())
                        .build());
    }

}
