package counter_application.src;

// Race condition can be avoided using these methods between 2 threads accessing the same data objects
// Using synchronized and concurrent collections like concurrent maps
// Using synchronised keywords for some code block and for a function

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class java_thread_safety {

    public static void main(String[] args)
    {
        Collection<Integer> synca = Collections.synchronizedCollection(new ArrayList<>());
        Thread t1 = new Thread(()-> synca.addAll(Arrays.asList(3,2,1,4,6,5)));
        Thread t2 = new Thread(() -> synca.addAll(Arrays.asList(12,10,9,7,16)));
        t1.start();
        t2.start();
        synca.forEach((el)->{
            System.out.println(el);
        });
    }
}
