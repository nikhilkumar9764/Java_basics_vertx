public class dog extends Animal{

    private static String dname;

    public dog(String iname)
    {
        this.dname = iname;
    }

    public void print_name()
    {
        System.out.println(dname);
    }
}


