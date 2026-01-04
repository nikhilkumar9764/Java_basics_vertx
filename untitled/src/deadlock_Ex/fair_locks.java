package deadlock_Ex;

import java.util.*;
import java.util.function.Consumer;

public class fair_locks {

    interface x1 {
        int calc(int x);
    }
    private static Object lock = new Object();
    public static void main(String[] args)
    {
         Worker w1 = new Worker("Blue");
         Worker w2 = new Worker("Purple");

         for(int j=0;j<5;j++) {
             w1.run();
             w2.run();
         }

        List<String> l1 = Arrays.asList("B","N" ,"U","J");
        Consumer<String> c = (sx) ->{
            System.out.println(sx);
        };
        l1.forEach(c);
        l1.stream().forEach(c);

        

        l1.parallelStream().forEach(c);

        Set<String> s1 = new HashSet<>();
        s1.add("Mohak");
        s1.add("Glenn");
        s1.add("Bailey");

        Iterator<String> it = s1.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        TreeMap<Integer,String> m1 = new TreeMap<>();
        m1.put(101 , "Kimber");
        m1.put(89 , "Tristian");
        m1.put(97, "Loki");
        m1.put(99, "Julia");

        m1.replace(89,"kooor");

        boolean x2 = m1.replace(89,"kooor","xmgdgd");
        System.out.println(x2);

        x1 one = (int y2)-> {
             y2 =  y2*4;
             return y2;
        };

        int xan = one.calc(7);
        System.out.println(xan);

        Consumer<List<Integer>> c1 = l2 -> {
            for(int j=0;j<l2.size();j++)
            {
                l2.set(j,l2.get(j)*2);
            }
        };

        Consumer<List<Integer>> c2 = l3 -> {
            for(int j=0;j<l3.size();j++)
            {
                System.out.println(l3.get(j));
            }
        };

        List<Integer> larr = Arrays.asList(13,12,4,2,6);
        c1.accept(larr);
        c2.accept(larr);

        for(Map.Entry x : m1.entrySet())
        {
            System.out.println(x.getKey()+" "+x.getValue());
        }
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
             synchronized (lock)
             {
                 if(threadcolor == "Blue")
                 {
                     runcount = runcount+5;
                 }
                 else if(threadcolor == "Purple")
                 {
                     runcount = runcount*2;
                 }
             }
             System.out.println("Thread " + threadcolor + " " + runcount);
        }
    }
}
