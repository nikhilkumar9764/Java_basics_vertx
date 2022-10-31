import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class VertxApp {

  public static void main(String[] args) { // This is OK
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new SendVerticle());     // line B
    vertx.deployVerticle(new ReceiveVerticle());  // line A
  }
}

class ReceiveVerticle extends AbstractVerticle{

  @Override
  public void start(Future<Void> startFuture) {
    vertx.eventBus().consumer("address", message -> {
      System.out.println("message received by receiver");
      System.out.println(message.body());
    });
  }
}

class SendVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws InterruptedException {
    System.out.println("SendVerticle started!");
    int i = 0;

    for (i = 0; i < 5000000; i++) {
      System.out.println("Sender sends a message " + i );
      vertx.eventBus().publish("address", "message" + i);
    }
  }
}
