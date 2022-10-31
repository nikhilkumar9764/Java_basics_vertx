package com.vertx_stock_broker.stock_broker;

import io.vertx.core.json.JsonObject;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class Quote {
   Asset as;
   BigDecimal bid;
   BigDecimal ask;
   BigDecimal lastPrice;
   BigDecimal volume;

   public JsonObject toJsonObj()
   {
      return JsonObject.mapFrom(this);
   }
}
