import java.util.Scanner;
import java.util.Collections.*;
import java.util.ArrayList;
import java.util.Arrays;
public class ContactList {
    private String name;
    private int pNum;
	public static void main(String[] args) {
	    System.out.println("Welcome to the Contact organizer. Please type <show commands> to view a list of possible commands");
		String c1 = "";
		int c2 = 0;
		Scanner scan = new Scanner(System.in); // new scanner object
		ArrayList<Contact> list = new ArrayList<>();// new arraylist
		System.out.println("Enter Command:");
		String command = scan.nextLine();
		String[] commands = {"view: shows list of your contacts in alphabetical order","add contact: adds a contact to your list of contacts","stop: exits the program"};
		String[] contacts = {}; //new array of type String
        int editNum = 0;
		//String formattedInt = "(" + f.substring(0,4) + ")" + "-" + f.substring(3,7) + "-" + f.substring(6,10); // creates a string of the inputted phone number in the format of (###)-###-####
		while(!command.equals("stop")) {
            if (command.equals("add contact")) {
                System.out.println("Please Input the contact name:");
                c1 = scan.nextLine();
                ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
                for(int i = 0; i < c1.length();i++) {
                	if(!alphabet.contains(c1.charAt(i))) {
                		System.out.println("Invalid Input");
                	}
                	break;
                }
                System.out.println("Please Input the Contact Phone Number:");
                c2 = scan.nextInt();
                if(Integer.toString(c2).length() != 10) {
                    System.out.println("Invalid Input: Phone Number must be 10 integers");
                }
                else {
                    Contact newContact = new Contact(c1, c2); // create new contact to add to the ArrayList
                    list.add(newContact);
                    System.out.println("Contact Successfully Added");
                }
            } else if (command.equals("view")) {
                contacts = new String[list.size()];
                for (int i = 0; i < list.size(); i++) { //loops through the entire size of list (in list elements)
                    contacts[i] = "#" + Integer.toString(i) + " " + "Contact Name: " + c1 + " " + "Contact Phone Number: " + Integer.toString(c2);

                }

                for (String a : contacts) {
                    System.out.println(a); //prints every element in contacts[]
                }
            } else if (command.equals("show commands")) {  // shows all available commands to the use
                for (String a : commands) {
                    System.out.println(a);
                }
            }
            else if(command.equals("edit")) {
                System.out.println("Please select the number contact you want to edit:");
                for (String a : contacts) {
                    System.out.println(a); //prints every element in contacts[]
                }
                editNum = scan.nextInt();
            }
            System.out.println('\n' + "Enter Command:");
            command = scan.nextLine();
        }
            System.exit(0);
	}
}
