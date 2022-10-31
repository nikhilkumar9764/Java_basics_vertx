package com.example.eventbus;

import com.example.eventloop.workerVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SenderReceiver {

  public static void main(String[] args) {
    Vertx v1 = Vertx.vertx();
    v1.deployVerticle(new Sender());
    v1.deployVerticle(new Receiver());
  }

  static class Sender extends AbstractVerticle{
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
           startPromise.complete();
           vertx.setPeriodic(1000, id->{
             vertx.eventBus().send(Sender.class.getName(),"Sending a new message...");
           });
    }
  }

  static class Receiver extends AbstractVerticle {
    private static final Logger log = LogManager.getLogger(Receiver.class);
    @Override
    public void start(final Promise<Void> startPromise) throws Exception {
           startPromise.complete();
           vertx.eventBus().consumer(Sender.class.getName(), val ->{
             log.debug("Received {}" , val);
           });
    }
  }
}
