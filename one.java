/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.function.Consumer;

/* Name of the class has to be "Main" only if the class is public. */
interface sample {
    void display();
}

interface X {
    default void m1(){
        System.out.println("HKADKDJKD");
    }
    int operation(int x, int y);
}


class Ideone1
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Consumer<String> c1 = (x1)->{
            System.out.println(x1);
        };
        c1.accept("Honorary flight");

        sample res = ()-> {
            System.out.println("Display method was called here!!");
        };
        res.display();

        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of numbers
        Consumer<List<Integer> >
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // Implement modify using accept()
        modify.accept(list);

        // Implement dispList using accept()
        dispList.accept(list);

        X sum = (p,q)-> p+q;
        X mul = (p,q)->p*q;
        sum.m1();
        System.out.println(sum.operation(4,6));
        System.out.println(mul.operation(5,7));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream().filter(x -> x%2==0).forEach(System.out::println);

    }
}