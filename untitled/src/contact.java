public class contact {

    private String name;
    private String phone_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public contact(String name, String phn_number)
    {
        this.name = name;
        this.phone_number = phn_number;
    }

    public static contact create_contact(String name, String phn_number)
    {
        return new contact(name,phn_number);
    }



}
