package com.example.eventloop;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class workerExample extends AbstractVerticle {

  private static final Logger log = LogManager.getLogger(workerExample.class);
  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
       startPromise.complete();
       log.debug("Deployed as worker verticle");
       Thread.sleep(5000);
       log.debug("Blocking operation done!!");
  }
}
