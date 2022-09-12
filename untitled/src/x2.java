import java.util.Scanner;

public class x2 {

    private static Scanner sc = new Scanner(System.in);
    private static Button b = new Button("Sample title");

    public static void main(String[] args)
    {
//       ITelephone i1;
//        i1 = new Customer(27484839,false);
//        i1.dial(43734484);
//        i1.powerOn();
//        System.out.println(i1.callphone(27484839));
//        i1.isRinging();
//        i1.answer();
//        Map<String, Integer> m1 = new HashMap<String,Integer>();
//        m1.put("Nicole",100);
//        m1.put("Kidman",150);
//        m1.put("Cadine",176);
//        for(Map.Entry m : m1.entrySet())
//        {
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
          class ClickListener implements Button.OnClickListener {
              public ClickListener()
              {
                  System.out.println("I was attaching!!");
              }
              @Override
              public void onclick(String title) {
                  System.out.println("A famous title to appear on board"+ " "+title);
              }
          }
         b.setOnClickListener(new ClickListener());
         listen();
    }

    public static void listen()
    {
        boolean quit = false;
        while(!quit)
        {
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch)
            {
                case 0:
                    quit = true;
                    break;
                case 1:
                    b.onclick();
                    break;
            }
        }
    }
}
