package com.example.eventloop;

import io.vertx.core.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class MainVerticle extends AbstractVerticle {
  private static final Logger log1 = LogManager.getLogger(MainVerticle.class);

  public static void main(String[] args) {
       Vertx v = Vertx.vertx(new VertxOptions()
           .setMaxEventLoopExecuteTime(500)
           .setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS)
         .setBlockedThreadCheckInterval(1)
         .setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS)
           .setEventLoopPoolSize(2)
         );
       v.deployVerticle(MainVerticle.class.getName(),new DeploymentOptions().setInstances(4));
       log1.info("This is a general information");
       log1.debug("Debugging errors");
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
      log1.debug("Start {}" , getClass().getName());
      startPromise.complete();
      //Do not do this inside a verticle
      Thread.sleep(5000);
  }
}
