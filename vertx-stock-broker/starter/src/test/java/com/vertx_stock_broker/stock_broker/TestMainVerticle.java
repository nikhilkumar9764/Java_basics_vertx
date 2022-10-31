package com.vertx_stock_broker.stock_broker;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(VertxExtension.class)
public class TestMainVerticle {

  private static Logger log = LogManager.getLogManager().getLogger(TestMainVerticle.class.getName());

  @BeforeEach
  void deploy_verticle(Vertx vertx, VertxTestContext testContext) {
    vertx.deployVerticle(new MainVerticle(), testContext.succeeding(id -> testContext.completeNow()));
  }

  @Test
  void get_all_assets(Vertx vertx, VertxTestContext testContext) throws Throwable {
       var client = WebClient.create(vertx , new WebClientOptions().setDefaultPort(MainVerticle.PORT1));
       client.get("/assets").send().onComplete(testContext.succeeding(resp -> {
              var r1 = resp.bodyAsJsonArray();
              System.out.println(r1);
              assertEquals("[{\"name\":\"Bengaluru\"},{\"name\":\"Trivandum\"},{\"name\":\"Panaji\"},{\"name\":\"Patna\"}]",r1.encode());
              assertEquals(200,resp.statusCode());
              testContext.completeNow();
         }
       ));
  }

  @Test
  void get_one_asset(Vertx vertx, VertxTestContext testContext) throws Throwable {
    var client = WebClient.create(vertx , new WebClientOptions().setDefaultPort(MainVerticle.PORT1));

     client.get("/quotes/Panaji").send().onComplete(testContext.succeeding(resp -> {
        var r1 =  resp.bodyAsJsonObject();
        System.out.println(r1);
        assertEquals("{\"as\":{\"name\":\"Panaji\"},\"bid\":265.5791697439236,\"ask\":543.7608663399759,\"lastPrice\":1986.2909374324302,\"volume\":null}",r1.encode());
        assertEquals(200,resp.statusCode());
        testContext.completeNow();
      }
    ));
  }

  @Test
  void get_unknown_asset(Vertx v,VertxTestContext vtc) throws Throwable {
        var client = WebClient.create(v, new WebClientOptions().setDefaultPort(MainVerticle.PORT1));
        client.get("/quotes/UNKNOWN").send().onComplete(vtc.succeeding(resp->{
              var x = resp.bodyAsJsonObject();
              assertEquals(404,resp.statusCode());
              assertEquals("{\"message\":\"Given asset not found!\",\"path\":\"/quotes/UNKNOWN\"}", x.encode());
              vtc.completeNow();
        }));
  }
}
