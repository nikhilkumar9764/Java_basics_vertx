import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class one {
    public static int two(int p,int q)
    {
        return p*q;
    }

   public static void main(String[] args)
   {
//       int x = 24;
//       System.out.println(x);
//       int res = two(34,55);
//       System.out.println(res);
//
//       int maxintval = Integer.MAX_VALUE;
//       int minintval = Integer.MIN_VALUE;
//       System.out.println(maxintval);
//       System.out.println(minintval);
//
//       System.out.println(maxintval+1);
//       System.out.println(minintval-1);
//
//       byte maxbyteval = Byte.MAX_VALUE;
//       byte minbyteval = Byte.MIN_VALUE;
//       System.out.println(maxbyteval);
//       System.out.println(minbyteval);
//
//       short minshortval = Short.MIN_VALUE;
//       short maxshortval = Short.MAX_VALUE;
//       System.out.println(minshortval);
//       System.out.println(maxshortval);
//
//       long val1 = Long.MAX_VALUE;
//       long val2 = Long.MIN_VALUE;
//       System.out.println(val1);
//       System.out.println(val2);
//
//       byte ans = (byte)(maxbyteval/2);
//       System.out.println(ans);
//
//       float x1 = Float.MAX_VALUE;
//       float x2 = Float.MIN_VALUE;
//       System.out.println(x1+" "+x2);
//
//       double x3 = Double.MAX_VALUE;
//       double x4 = Double.MIN_VALUE;
//       System.out.println(x3+" "+x4);
//
//       int a = 20;
//       float b = (float)4.56;
//       double c = 5.68;
//       System.out.println(b+c);

       List<Integer> x1 = new ArrayList<>();
       List<String> x2 = new LinkedList<>();
       Scanner sb = new Scanner(System.in);
       for(int i=0;i<3;i++)
       {
           String s1 = sb.nextLine();
           x2.add(s1);
       }
       for(int k=0;k<x2.size();k++)
       {
           System.out.println(x2.get(k));
       }

   }
}
