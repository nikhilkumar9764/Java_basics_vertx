public class Foo {
    private int id;
    String name;

    public void setId(int a) {
        id = a;
    }

    public int getId() {
        return id;
    }
}
class one {
     private static int x = 10;
    public static void main(String[] args) {
        System.out.println(one.x++);
        System.out.println(one.x);
        Foo o1 = new Foo();
        o1.name = "mohan";
        o1.setId(10);
        System.out.println(o1.getId());
    }
}