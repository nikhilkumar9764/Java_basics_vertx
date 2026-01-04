public class scope {
    private static int x = 10;
    int j = 20;

    public static void main(String[] args) {
         scope s1 = new scope();
         int j = 30;
         System.out.println(s1.x);
        System.out.println(s1.j);
        System.out.println(j);

        s1.x = 400;
        s1.j=200;
        System.out.println(s1.x);
        System.out.println(s1.j);
    }

}
