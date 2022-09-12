import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


class Service1 implements Callable<String> {
    int i;
    public Service1(int i)
    {
        this.i = i;
    }

    @Override
    public String call() {
        System.out.println("for thread"+i);
        return "thread number"+i;
    }
}

public class executor_callable
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(new Date());
        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Future<String>> ls = new ArrayList<>();
        for(int j=0;j<10;j++)
        {
            ls.add(es.submit(new Service1(j)));
        }
        es.shutdown();
        System.out.println("=============");
        for(Future<String> fut : ls)
        {
            System.out.println(fut.get());
        }
    }
}
