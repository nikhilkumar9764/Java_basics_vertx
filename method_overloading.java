public class method_overloading {

    public static void main(String[] args)
    {
        int val1 = get_score("Mohit",403);
        int val2 = get_score(553);
        System.out.println(val1+val2);
    }

    public static int get_score(String name,int vb)
    {
        System.out.println("Player's name is "+name +" " + "Points scored :"+vb);
        return vb+20;
    }

    public static int get_score(int vb)
    {
        System.out.println("Points scored :"+vb);
        return vb-20;
    }
}

