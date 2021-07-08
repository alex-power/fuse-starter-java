package org.galatea.starter.service;

import java.util.List;
import org.galatea.starter.domain.IexHistoricalPrices;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "IEX2", url = "${spring.rest.iexBasePath2}")
public interface Iex2Client {

  /**
   * Get the historical price price for each stock symbol passed in.
   * Useful link: https://stackoverflow.com/questions/38032635/pass-multiple-parameters-to-rest-api-spring/38032778
   *
   * @param symbol one symbol to get historical prices for.
   * @param range (1y,5y,1m, ytd ....etc) a time range to get historical prices for.
   * @return a List of IexHistoricalPrices objects for the given symbol and time series
   */
  @GetMapping(path = "/stock/{symbol}/chart/{range}?token=${spring.rest.token}")
  List<IexHistoricalPrices> getHistoricalPricesForSymbol(
      @PathVariable("symbol") String symbol,
      @PathVariable("range") String range
  );
}

