import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// This program demonstrates submit(new Runnable()) being used
class Service implements Runnable{
    int i;
    public Service(int i)
    {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("In thread "+i);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Something went wrong here!!");
        }
    }
}

public class executorutility {

    public static void main(String[] args) throws InterruptedException , ExecutionException
    {
        System.out.println(new Date());
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Future<String>> ls = new ArrayList<>();
        for(int j=0;j<10;j++)
        {
            ls.add((Future<String>)es.submit(new Service(j)));
        }
        es.shutdown();
        System.out.println("=============");
        for(Future<String> fut : ls)
        {
            System.out.println(fut.get());
        }
    }
}
