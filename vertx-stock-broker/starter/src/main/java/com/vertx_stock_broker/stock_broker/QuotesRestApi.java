package com.vertx_stock_broker.stock_broker;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class QuotesRestApi {

  private static final Logger log = LoggerFactory.getLogger(AssetsRestApi.class.getName());
  static void attach(Router parent)
  {
    Map<String,Quote> mp = new HashMap<>();
    AssetsRestApi.l1.forEach(val ->{
       mp.put(val , initQuote(val));
    });
       parent.get("/quotes/:asset").handler(ctx -> {
           final String assetparam = ctx.pathParam("asset");
           log.debug("Asset param is : {} ", assetparam);

           var q1 = Optional.ofNullable(mp.get(assetparam));

           if(q1.isEmpty()) {
             ctx.response().setStatusCode(404).end(new JsonObject()
               .put("message", "Given asset not found!")
               .put("path", ctx.normalizedPath()).toBuffer());
             return;
           }
           final JsonObject res = JsonObject.mapFrom(q1.get());
           log.debug("Path {} responded with {}" , ctx.normalizedPath() , res.encode());
           ctx.response().end(res.toBuffer());
       });
  }

  private static Quote initQuote(final String val) {
    return Quote.builder().
      as(new Asset(val))
      .bid(randomval())
      .ask(randomval())
      .lastPrice(randomval())
      .build();
  }

  private static BigDecimal randomval()
  {
      return BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1,2000));
  }
}
