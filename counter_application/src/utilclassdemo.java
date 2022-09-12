import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class utilclassdemo {
    private static final String EOF = "EOF";
    public static void main(String[] args)
    {
        List<String> buffer = new ArrayList<String>();
        String color;
        ReentrantLock rl = new ReentrantLock();

        Producer p = new Producer(buffer,ThreadColor.ANSI_GREEN,rl);
        Consumer c1 = new Consumer(buffer,ThreadColor.ANSI_PURPLE,rl);
        Consumer c2 = new Consumer(buffer,ThreadColor.ANSI_CYAN,rl);

        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable{

    private List<String> buf;
    private String color;
    private ReentrantLock bufferlock;
    public Producer(List<String> buf,String col, ReentrantLock lock)
    {
        this.buf = buf;
        this.color = col;
        this.bufferlock = lock;
    }
    @Override
    public void run() {
        Random r = new Random();
        String[] nums = {"one" , "two" , "three" ,"four" , "five"};
        for(String x : nums)
        {
            try{
                System.out.println(this.color+"Adding number : "+x);
                bufferlock.lock();
                buf.add(x);
                bufferlock.unlock();
                Thread.sleep(2000);
            }
            catch (InterruptedException ex)
            {
                System.out.println("Producer was interruped");
            }
        }
        System.out.println(color + " we are exiting now...");
        bufferlock.lock();
        buf.add("EOF");
        bufferlock.unlock();
    }
}

class Consumer implements Runnable {

    private List<String> buf;
    private String vv;

    private ReentrantLock bufferlock;

    public Consumer(List<String> x , String c, ReentrantLock lock)
    {
        this.buf = x;
        this.vv = c;
        this.bufferlock = lock;
    }
    @Override
    public void run() {
        while (true)
        {
             bufferlock.lock();
                if (buf.isEmpty()) {
                    bufferlock.unlock();
                    continue;
                }
                if (buf.get(0).equals("EOF")) {
                    System.out.println("Exiting...");
                    bufferlock.unlock();
                    break;
                } else {
                    System.out.println(this.vv + "Removing " + buf.remove(0));
                }
            bufferlock.unlock();
        }
    }
}