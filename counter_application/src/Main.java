public class Main {

     public static void main(String[] args)
     {
          Countdown p1 = new Countdown();
          Countdown p2 = new Countdown();
          CountdownThread one = new CountdownThread(p1);
          one.setName("Thread 1");
          CountdownThread two = new CountdownThread(p1);
          two.setName("Thread 2");

          one.start();
          two.start();
          try{
               two.sleep(1000);
          }
          catch(Exception e){
               System.out.println("ex");
         }
     }
}


class Countdown{
    private int i;

    public void doCountdown()
    {
         String color;
         switch(Thread.currentThread().getName())
         {
              case "Thread 1":
                   color = ThreadColor.ANSI_BLUE;
                   break;

              case "Thread 2":
                   color = ThreadColor.ANSI_CYAN;
                   break;

              default :
                   color = ThreadColor.ANSI_PURPLE;
         }

         synchronized (color) // Local variable copy available in thread stack of each thread . But if we put synchronized on object reference
                 // of each thread , then there will be no interleaving between threads.
         {
              for (i = 10; i > 0; i--) {
                   System.out.println(color + Thread.currentThread().getName() + ":i = " + i);
              }
         }
    }
}

class CountdownThread extends Thread
{
     private Countdown c1;

     public CountdownThread(Countdown x)
     {
          c1 = x;
     }

     @Override
     public void run()
     {
          c1.doCountdown();
     }
}
