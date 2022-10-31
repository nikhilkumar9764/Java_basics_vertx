package com.example.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestResponseExample {


  public static void main(String[] args) {
      Vertx v = Vertx.vertx();
      v.deployVerticle(new RequestVerticle() , new DeploymentOptions()
        .setWorker(false).setWorkerPoolSize(1).setWorkerPoolName("my-custom-thread-x"));
      v.deployVerticle(new ResponseVerticle());
  }
  static class RequestVerticle extends AbstractVerticle{
    private static final Logger log = LogManager.getLogger(RequestVerticle.class);
    public static final String ADDRESS = "my.request.address";
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
          startPromise.complete();
          var bus = vertx.eventBus();
          final String message = "Hello world!!";
          log.debug("Sending message {}", message);
          bus.request(ADDRESS , message , reply -> {
            System.out.println(reply.result().body().toString());
//            log.debug("Received {}",reply.result().body().toString());
          });
    }
  }

  static class ResponseVerticle extends AbstractVerticle{
    private static final Logger log = LogManager.getLogger(ResponseVerticle.class);
    public static final String ADDRESS = "my.request.address";
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
        startPromise.complete();
        vertx.eventBus().<String>consumer(ADDRESS, msg -> {
           log.debug("Received message {}" , msg.body());
           msg.reply("Received your message , Thanks!");
        });
    }
  }
}
