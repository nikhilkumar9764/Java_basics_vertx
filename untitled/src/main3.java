import java.util.Scanner;

public class main3 {
    private static Scanner sc = new Scanner(System.in);
    private static Phonenumber ph = new Phonenumber("9854833823");

    public static void main(String[] args)
    {
        boolean quit = false;
        startphone();
        print_options();
        while(!quit)
        {
            System.out.println("Enter option as per choice\n");
            int val = sc.nextInt();
            switch(val)
            {
                case 0:
                    quit = true;
                    break;
                case 1:
                   ph.print_contacts();
                   break;
                case 2:
                    addnewcontact();
                    break;
                case 3:
                    updatecontact();
                    break;
                case 4:
                    remove_contact();
                    break;
                case 6:
                    print_options();
                    break;
            }
        }
    }

    private static void addnewcontact()
    {
        Scanner sb = new Scanner(System.in);
        System.out.println("Enter a name!!");
        String s1 = sb.nextLine();
        System.out.println("Enter a phone number!!");
        String s2 = sb.nextLine();
        contact c2 = new contact(s1,s2);
        if(ph.addcontact(c2))
        {
            System.out.println("contact added!!");
        }
        else{
            System.out.println("Contact already exists!!");
        }
    }

    public static void remove_contact()
    {
        System.out.println("Enter existing name!");
        Scanner sb = new Scanner(System.in);
        String curr_name = sb.nextLine();
        contact cv = ph.query_contact(curr_name);
        if(cv == null)
        {
            System.out.println("Contact does not exist");
            return;
        }
        if(ph.remove_contact(cv))
        {
            System.out.println("Done!!");
        }
        else{
            System.out.println("Couldn't delete record!");
        }
    }

    private static void updatecontact()
    {
        System.out.println("Enter existing name!");
        Scanner sb = new Scanner(System.in);
        String curr_name = sb.nextLine();
        if(ph.query_contact(curr_name) == null)
        {
            System.out.println("Contact does not exist");
            return;
        }
        System.out.println("Enter a new name!!");
        String s1 = sb.nextLine();
        System.out.println("Enter a new phone number!!");
        String s2 = sb.nextLine();
        contact cv = ph.query_contact(curr_name);
        contact cp = new contact(s1,s2);
        if(ph.update_contact(cv,cp))
        {
            System.out.println("Done!!");
        }
        else{
            System.out.println("Couldn't update record!");
        }
    }


    private static void startphone()
    {
        System.out.println("Starting phone!!");
    }

    private static void print_options()
    {
        System.out.println("Available options are : \n");
        System.out.println("0 -- shutdown\n"+
                         "1 -- to print contacts \n"+
                            "2-- to add a new contact\n"+
                         "3 -- to update an existing contact\n"+
                         "4 -- to remove an existing contact\n" +
                         "5 -- query if a contact already exists\n"+
                         "6 -- to print list of available actions\n");
    }
}
