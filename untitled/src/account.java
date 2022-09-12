public class account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public account()
    {
        this("34535467", 4.6778, "Mohak Mangal", "mohak.1@gmail.com" , "9944576324");
        System.out.println("Empty constructor called!!");
    }

    public account(String number, double bal, String cust_name , String cust_email, String cust_phone)
    {
        System.out.println("Parameterized called!!");
        this.number = number;
        this.balance = bal;
        this.customerName = cust_name;
        this.customerEmail = cust_email;
        this.customerPhone = cust_phone;
    }

    public void deposit(double amt)
    {
        this.balance+=amt;
        System.out.println("Deposit of amount " + amt + "done. " + "New balance is: "+this.balance);
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
