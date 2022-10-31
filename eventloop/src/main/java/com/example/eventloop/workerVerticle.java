package com.example.eventloop;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class workerVerticle extends AbstractVerticle {

  private static final Logger log = LogManager.getLogger(workerVerticle.class);

  public static void main(String[] args) {
    Vertx v1 = Vertx.vertx();
    v1.deployVerticle(new workerVerticle());
  }

  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
    vertx.deployVerticle(new workerExample() , new DeploymentOptions()
      .setWorker(true).setWorkerPoolSize(1)
      .setWorkerPoolName("my-worker-cust"));

    startPromise.complete();
    vertx.executeBlocking(event -> {
      log.debug("Executing blocking code here!!");
      try{
         Thread.sleep(5000);
         event.fail("some vague reason");
      }
      catch(InterruptedException e)
      {
          log.error("Failed due to!"+e);
          event.fail(e);
      }
    }, result -> {
      if(result.succeeded())
      {
         log.debug("Blocking code done!!");
      }
      else{
          log.debug("This caused an error"+ result.cause());
      }
    });
  }
}
