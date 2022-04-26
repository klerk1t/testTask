package com.exchange.repository;

import com.exchange.entity.CurrencyRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CurrencyRateRepository extends CrudRepository<CurrencyRate, Long> {

    @Query(value = "SELECT avg(DISTINCT(rate))\n" +
            "from currency_rate\n" +
            "where date >= current_date", nativeQuery = true)
    BigDecimal findAverageRateByDate();

}
