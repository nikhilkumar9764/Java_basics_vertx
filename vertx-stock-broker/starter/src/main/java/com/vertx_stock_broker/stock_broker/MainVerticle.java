package com.vertx_stock_broker.stock_broker;
import com.sun.tools.javac.Main;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {
  public static final int PORT1 = 8888;
  private static final Logger log = LoggerFactory.getLogger(MainVerticle.class.getName());

  public static void main(String[] args) {
    Vertx v1 = Vertx.vertx();

    v1.exceptionHandler(err->
      log.error("Error occurred due to",err)
    );

    v1.deployVerticle(new MainVerticle() , ar->{
      if(ar.failed())
      {
         log.error("Failed due to {}",ar.cause());
      }
    });
    log.info("Deployed {}", MainVerticle.class.getName());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    final Router router = Router.router(vertx);

    router.route().failureHandler(ctx -> {
       if(ctx.response().ended())
       {
           return;
       }
       log.info("Route error: " , ctx.failure());
       ctx.response()
         .setStatusCode(500).
         end(new JsonObject().put("message" , "Something went wrong here!!").toBuffer());
    });
    AssetsRestApi.attach(router);
    QuotesRestApi.attach(router);

    vertx.createHttpServer().requestHandler(router)
      .exceptionHandler(err -> {
        log.error("Http server error" , err);
      }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
