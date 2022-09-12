import java.util.ArrayList;

class IntClass {
    private int x;

    public IntClass(int val)
    {
        this.x  = val;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

public class auto_boxing
{
    public static void main(String[] args)
    {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(54);
        System.out.println(x);
        ArrayList<IntClass> y = new ArrayList<IntClass>();
        ArrayList<Integer> z = new ArrayList<Integer>();
        y.add(new IntClass(4567));
        for(int i=0;i<10;i++)
        {
            z.add(Integer.valueOf(i));
        }
        System.out.println(y);
        System.out.println(z);
    }
}
