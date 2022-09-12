class Movie{
     private String name;

     public Movie(String name)
     {
         this.name = name;
     }

     public String plot()
     {
         return "No plot here";
     }

     public String getname()
     {
         return this.name;
     }
}

class Jaws extends Movie {
     public Jaws()
     {
         super("Jaws invoked!!");
     }

    @Override
    public String plot()
    {
        return "Shark has a lot of jaws";
    }
}

class Independence extends Movie {
     public Independence()
     {
         super("Independence invoked!");
     }

     @Override
    public String plot()
     {
         return "Independence is beauty";
     }
}



public class Main2 {
    public static void main(String[] args)
    {
        for(int j=0;j<4;j++)
        {
            Movie m = randomgen();
            System.out.println("Movie id is : "+j + " Plot is :"+m.plot());
        }
    }

    public static Movie randomgen()
    {
        int val = (int)(Math.random()*5)+1;
        System.out.println("Random number generated is : "+val);
        switch(val)
        {
            case 1:
                return new Movie("brahamastra");
            case 2:
                return new Jaws();
            default:
                return new Independence();
        }
    }

}
