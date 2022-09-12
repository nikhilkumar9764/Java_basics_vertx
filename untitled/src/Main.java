import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] x= new int[10];
        Scanner obj = new Scanner(System.in);
        for(int i=0;i<10;i++)
        {
            int val = obj.nextInt();
            x[i] = val;
            System.out.println(val);
        }

        int len = x.length;

        for(int i=0;i<len/2;i++)
        {
            int tmp = x[i];
            x[i] = x[len-1-i];
            x[len-1-i] = tmp;
        }

        for(int i=0;i<len;i++)
        {
            System.out.println(x[i]);
        }
//        Car porsche = new Car();
//        porsche.setModel("commodore");
//        String r1 = porsche.getModel();
//        System.out.println(r1);
//
//        account a = new account();
//        dog d1 = new dog("fluffy");
//        dog d2 = new dog("cathy");
//        d1.print_name();
//        d2.print_name();
    }
}
