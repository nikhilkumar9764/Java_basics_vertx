public interface ITelephone {
    void powerOn();
    void dial(int number);
    void answer();
    boolean callphone(int ph_number);
    boolean isRinging();
}
