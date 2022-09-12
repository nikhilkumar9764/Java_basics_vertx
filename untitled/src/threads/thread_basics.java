package threads;

import static threads.thread_color.*;

public class thread_basics {

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE+  "Hello from the main thread!!");
        Thread t = new another_thread();
        t.setName(t.getName());
        t.start();

        new Thread()
        {
            public void run()
            {
                System.out.println(ANSI_GREEN+"Anonymous thread running");
            }
        }.start();

        Thread t2 = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN+"Hello from overridden runnable method");
                try{
                    t.join();
                }
                catch(InterruptedException e)
                {
                    System.out.println(ANSI_RED + "");
                }
            }
        });
        t2.start();
        t.interrupt();
        System.out.println(ANSI_PURPLE+"Hello again from the main thread!!");
    }
}
