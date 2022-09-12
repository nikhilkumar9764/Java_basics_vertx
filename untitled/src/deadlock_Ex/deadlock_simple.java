package deadlock_Ex;

public class deadlock_simple {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String args[])
    {
         new Thread(new one()).start();
         new Thread(new two()).start();
    }

    private static class one implements Runnable {

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }

                System.out.println("Thread1 : waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1 : Has lock2");
                }
            }
        }
    }

    private static class two implements Runnable {

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2 : waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 2 : Has lock2");
                }
            }
        }
    }
}




