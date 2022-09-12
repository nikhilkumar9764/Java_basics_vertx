package deadlock_Ex;

public class fair_locks {

    private static Object lock = new Object();
    public static void main(String[] args)
    {

    }

    private static class Worker implements Runnable {

        private int runcount = 1;
        private String threadcolor;

        private Worker(String color)
        {
            this.threadcolor = color;
        }

        @Override
        public void run() {
             for()
        }
    }
}
