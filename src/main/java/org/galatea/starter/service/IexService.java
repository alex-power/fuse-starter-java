package org.galatea.starter.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.galatea.starter.domain.IexSymbol;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.galatea.starter.domain.IexLastTradedPrice;
import org.galatea.starter.domain.IexHistoricalPrice;
import org.galatea.starter.service.IexCloudClient;

/**
 * A layer for transformation, aggregation, and business required when retrieving data from IEX.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class IexService {

  @NonNull
  private IexCloudClient iexCloudClient;
  private IexClient iexClient;
  private Set<IexHistoricalPrice> cacheSet;

  public IexService(){
    cacheSet = new HashSet<IexHistoricalPrice>();
  }

  /**
   * Get all stock symbols from IEX.
   *
   * @return a list of all Stock Symbols from IEX.
   */
  public List<IexSymbol> getAllSymbols() {
    return iexClient.getAllSymbols();
  }

  /**
   * Get the last traded price for each Symbol that is passed in.
   *
   * @param symbols the list of symbols to get a last traded price for.
   * @return a list of last traded price objects for each Symbol that is passed in.
   */
  public List<IexLastTradedPrice> getLastTradedPriceForSymbols(final List<String> symbols) {
    if (CollectionUtils.isEmpty(symbols)) {
      return Collections.emptyList();
    } else {
      return iexClient.getLastTradedPriceForSymbols(symbols.toArray(new String[0]));
    }
  }

  public List<IexHistoricalPrice> getHistoricalPrices(String symbol, String range){
    if(cacheSet.contains())
      return iexCloudClient.getHistoricalPrices(symbol, range);
    }
  }


