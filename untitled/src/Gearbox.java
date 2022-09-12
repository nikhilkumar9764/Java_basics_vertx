import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxgears;
    private int gearnumber = 0;
    private boolean isClutchIn;

    public Gearbox(int maxGears)
    {
        this.maxgears = maxGears;
        this.gears = new ArrayList<Gear>();
    }

    public void operateclutch(boolean in)
    {
        this.isClutchIn = in;
    }

    public void addgear(int gear, double ratio)
    {
        if(gear>=0 && gear<=maxgears)
        {
            this.gears.add(new Gear(gear,ratio));
        }
        for(int i=0;i<this.gears.size();i++)
        {
            System.out.println(this.gears.get(i).gearnumber);
        }
    }

    public void change_gear(int newgear)
    {
        if(newgear>=0 && newgear<=maxgears && isClutchIn)
        {
            this.gearnumber = newgear;
            System.out.println("Gear "+newgear+" selected");
        }
        else{
            System.out.println("Grind!!");
        }
    }

    private double wheel_speed(int revs)
    {
        if(isClutchIn)
        {
            System.out.println("Scream!!");
            return 0.00;
        }
        return revs*gears.get(gearnumber).getRatio();
    }

    public class Gear
    {
        private int gearnumber;
        private double ratio;

        public Gear(int gearno , double rat)
        {
            this.gearnumber=gearno;
            this.ratio = rat;
        }

        public double getRatio() {
            return ratio;
        }

        public double get_speed(int revs)
        {
            return revs*this.ratio;
        }
    }
}
