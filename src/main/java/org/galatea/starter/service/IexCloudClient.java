package org.galatea.starter.service;

import org.galatea.starter.domain.IexHistoricalPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.galatea.starter.domain.IexHistoricalPrice;

import java.util.List;

@FeignClient(name = "IEXCC", url = "${spring.rest.iexCloudPath}")
public interface IexCloudClient {

    @GetMapping("/{symbol}/chart/{range}?token=${spring.rest.cloudKey}")
    List<IexHistoricalPrice> getHistoricalPrices(@PathVariable("symbol") String symbol,
                                                 @PathVariable("range") String range);

}