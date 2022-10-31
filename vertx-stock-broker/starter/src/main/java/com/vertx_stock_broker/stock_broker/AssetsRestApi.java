package com.vertx_stock_broker.stock_broker;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class AssetsRestApi {
   private static final Logger log = LoggerFactory.getLogger(AssetsRestApi.class.getName());

   public static final List<String> l1 = Arrays.asList("Bengaluru","Trivandum","Panaji","Patna");
   static void attach(Router parent)
   {
     parent.get("/assets").handler(context ->{
       final JsonArray resp = new JsonArray();
       l1.stream().map(Asset::new).forEach(resp::add);
       log.info("Path {} responded with {}",context.normalizedPath(), resp.encode());
       context.response().end(resp.toBuffer());
     });
   }

}
