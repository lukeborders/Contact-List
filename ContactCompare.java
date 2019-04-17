import java.util.Comparator;
public class ContactCompare implements Comparator<Contact> {

    /*Overrides compare method to compare Contacts*/
    public int compare(Contact contact1, Contact contact2) {

        //This is getting the last names from 2 contacts and upper casing them to make it not
        //case sensitive and then comparing them
        int nameCompare = contact1.getName().toUpperCase().compareTo(contact2.getName().toUpperCase());

       return nameCompare;
    }
}