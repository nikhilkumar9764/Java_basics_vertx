package threads;

import static threads.thread_color.ANSI_BLUE;
import static threads.thread_color.ANSI_CYAN;

public class another_thread extends Thread{
     public void run()
     {
         System.out.println(ANSI_CYAN+" thread is running here!!");
         try{
             Thread.sleep(3000);
         }
         catch(InterruptedException a)
         {
             System.out.println(ANSI_BLUE + "Another thread has woken me up!!");
         }
         System.out.println("Three seconds have passed and I am awake now!!");
     }
}
