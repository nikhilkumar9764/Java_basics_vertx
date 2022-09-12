import java.util.ArrayList;
import java.util.Objects;

public class Phonenumber {

    public String mynumber;
    public ArrayList<contact> Contacts;

    public Phonenumber(String mynumber) {
        this.mynumber = mynumber;
        this.Contacts = new ArrayList<>();
    }

    public boolean addcontact(contact contact)
    {
         if(find_idx(contact)>=0)
         {
             System.out.println("This contact is already present");
             return false;
         }
         Contacts.add(contact);
         return true;
    }

    public int find_idx(contact contact)
    {
        return Contacts.indexOf(contact);
    }

    public int find_idx(String name)
    {
        System.out.println(this.Contacts.size());
        for(int j=0;j<this.Contacts.size();j++)
        {
            contact c1 = this.Contacts.get(j);
            System.out.println(c1.getName());
            if(Objects.equals(c1.getName(), name))
            {
                System.out.println("here at"+j);
                return j;
            }
        }
        return -1;
    }

    public void print_contacts()
    {
        System.out.println("Contact list is:\n");
        for(int i=0;i<this.Contacts.size();i++)
        {
            System.out.println(this.Contacts.get(i).getName()+"--->"+this.Contacts.get(i).getPhone_number());
        }
    }
    public boolean update_contact(contact curr_contact,contact new_contact)
    {
        int idx = find_idx(curr_contact);
        if(idx<0)
        {
            System.out.println("Given contact does not exist");
            return false;
        }
        this.Contacts.set(idx,new_contact);
        System.out.println("Contact updated successfully");
        return true;
    }

    public contact query_contact(String name)
    {
         int pos = find_idx(name);
         System.out.println(pos);
         if(pos>=0)
         {
             return this.Contacts.get(pos);
         }
         return null;
    }

    public String query_contact(contact c1)
    {
        if(find_idx(c1)>=0)
        {
            System.out.println("Contact was found "+ "Its name is : ");
            return c1.getName();
        }
        System.out.println("Contact was not found!!");
        return null;
    }

    public boolean remove_contact(contact c)
    {
        int idx = find_idx(c);
        if(idx<0)
        {
            System.out.println("Given contact does not exist");
            return false;
        }
        this.Contacts.remove(idx);
        System.out.println("Contact removed successfully");
        return true;
    }
}
