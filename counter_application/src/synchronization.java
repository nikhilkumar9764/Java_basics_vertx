import java.util.ArrayList;

public class synchronization {
    public static void main(String[] args)
    {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(14);
        x.add(23);
        x.add(78);
        x.add(19);
        x.forEach((val) -> {
            System.out.println("Current value is :" + val);
        });
    }

}
