public class Customer implements ITelephone{

    private int mynumber;
    private boolean isRinging;

    public Customer(int mynum, boolean isRing)
    {
        this.mynumber = mynum;
        this.isRinging = isRing;
    }

    @Override
    public void powerOn() {
        System.out.println("No action , desk phone doesn't have a power button!");
    }

    @Override
    public void dial(int number) {
        System.out.println("Now ringing "+ number + " on the cellphone");
    }

    @Override
    public void answer() {
        if(isRinging) {
            System.out.println("Answering the phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callphone(int ph_number)
    {
        if(ph_number == mynumber)
        {
            isRinging = true;
        }
        else{
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
