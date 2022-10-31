package com.example.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Codec_PingPong {
  public static void main(String[] args) {
    Vertx v1 = Vertx.vertx();
    v1.deployVerticle(new PingVerticle());
    v1.deployVerticle(new PongVerticle());
  }

  static class PingVerticle extends AbstractVerticle {
    private static final Logger log = LogManager.getLogger(PingVerticle.class);
    public static final String ADDRESS = PingVerticle.class.getName();

    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      var bus = vertx.eventBus();
      bus.registerDefaultCodec(Ping.class,new LocalMessageCodec<>(Ping.class));
      final Ping m1 = new Ping("This is a ping sample msg" , true);
      log.debug("Sending message {}", m1);
      bus.<Pong>request(ADDRESS , m1 , reply -> {
        log.debug("Received {}",reply.result().body());
      });
      startPromise.complete();
    }

  }

  static class PongVerticle extends AbstractVerticle{
    private static final Logger log = LogManager.getLogger(PongVerticle.class);
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
      startPromise.complete();
      vertx.eventBus().registerDefaultCodec(Pong.class,new LocalMessageCodec<>(Pong.class));
      vertx.eventBus().<Ping>consumer(PingVerticle.ADDRESS, (msg) -> {
        log.debug("Received message {}" , msg.body());
        msg.reply(new Pong(0));
      });
    }
  }
}
