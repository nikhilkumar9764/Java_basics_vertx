import java.util.Random;

public class producer_consumer
{
    public static void main(String[] args)
    {
          Message new_msg = new Message();
          new Thread(new Writer(new_msg)).start();
          new Thread(new Reader(new_msg)).start();
    }
}

class Message
{
    private String message;
    private boolean empty = true;
    public synchronized String read()
    {
        while (empty)
        {
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String x)
    {
        while(!empty)
        {
        }
        empty = false;
        this.message = x;
        notifyAll();
    }
}

class Writer implements Runnable{
    private Message msg;

    public Writer(Message m)
    {
        this.msg = m;
    }

    public void run()
    {
        String[] m = {"Humpty Dumpty sat" , "Humpty had a great fall" , "All the kings horses fell" , "Couldn't put humpty"};
        Random x = new Random();
        for(int i=0;i<m.length;i++) {
            msg.write(m[i]);
            try {
                Thread.sleep(x.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("An exception occurred here !!");
            }
        }
        msg.write("Finished");
    }
}

class Reader implements Runnable {
    private Message msg;

    public Reader(Message x)
    {
        this.msg = x;
    }

    @Override
    public void run() {
        Random r = new Random();
        for(String m = msg.read();!m.equals("Finished");m = msg.read())
        {
            System.out.println(m);
            try{
                Thread.sleep(r.nextInt(2000));
            }
            catch (InterruptedException i)
            {
                System.out.println("An exception occurred here!!");
            }
        }
    }
}