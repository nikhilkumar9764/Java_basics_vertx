package com.example.Promises_Futures;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class promises_future_example {
  private static final Logger l1 = LogManager.getLogger(promises_future_example.class);
  @Test
  void promise_success(Vertx v , VertxTestContext context)
  {
      final Promise<String> x1 =Promise.promise();
      l1.debug("Started!!");
      v.setTimer(500,x->{
         l1.debug("Success");
         x1.complete("Success");
         context.completeNow();
      });
      l1.debug("End");
  }

  @Test
  void promise_failure(Vertx v ,VertxTestContext con)
  {
    final Promise<String> x2 =Promise.promise();
    l1.debug("Started!!");
    v.setTimer(500,x->{
      l1.debug("Failure");
      x2.fail(new RuntimeException("Failed!"));
      con.completeNow();
    });
    l1.debug("End");
  }

  @Test
  void future_success(Vertx v, VertxTestContext con)
  {
      final Promise<String> p1 = Promise.promise();
      l1.debug("Started!!");
      v.setTimer(500 , x ->{
        l1.debug("Success!!");
      });
      final Future<String> f1 =  p1.future();
      p1.complete("This was done successfully!!");
      if(f1.succeeded())
      {
           l1.debug("Result {}",f1.result());
           con.completeNow();
      }
      else{
          f1.fail("some reason");
      }
  }

  @Test
  void future_failure(Vertx v , VertxTestContext vtc)
  {
      Promise<String> p1 = Promise.promise();
      Future<String> fd = p1.future();

  }

}
