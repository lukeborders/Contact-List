import java.util.Scanner;
import java.util.Collections.*;
import java.util.ArrayList;
public class ContactList {
	private String name;
	private int pNum;
		
	public static void main(String[] args) {
	    System.out.println("Welcome to the Contact organizer. Please type <show commands> to view a list of possible commands");
		String c1 = "";
		int c2 = 0; 
		Scanner scan = new Scanner(System.in); // new scanner object
		ArrayList<Contact> list = new ArrayList<>();// new arraylist
		//Collections.sort(list);   NEED TO FIX [CANNOT FIND SYMBOL!!!]
		if(scan.nextLine().equals("add contact")) {
           		System.out.println("Please Input the contact name:");
            		c1 = scan.nextLine();
			char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			//String na = scan.nextLine();
			/*for(int i = 0; i < na.length();i++) {
				for(int m = 0; m < alphabet.length; m++) {
					if(na.charAt(i) != alphabet[m] ) {
						System.out.println("invalid input, try again:");
						i=na.length();
						na = scan.nextLine();
					}		
				}
			} */
			System.out.println("Please Input the Contact Phone Number");
			c2 = scan.nextInt();
			Contact newContact = new Contact(c1,c2); // create new contact to add to the ArrayList
			list.add(newContact);
			System.out.println("Contact Successfully Added");
		}
		else if(scan.nextLine().equals("view")) {
            		String[] contacts = {}; //new array of type String
            		String f = Integer.toString(c2); //new string of converted c2 int
            		String formattedInt = "(" + f.substring(0,4) + ")" + "-" + f.substring(3,7) + "-" + f.substring(6,11); // creates a string of the inputted phone number in the format of (###)-###-####
            		String format = "Contact Name: " + c1 + "Contact Phone Number: " + f;
		    			for(int i = 0; i < list.size(); i++) { //loops through the entire size of list (in list elements)
		        			for(int n = 0; n < contacts.length; n++) {
		            			contacts[n] =  Integer.toString(i) + format;
                		}
            		}

			for(String a: contacts) {
				System.out.println(a); //prints every element in contacts[]
			}
		}
		else if(scan.nextLine().equals("stop")) {
			System.exit(0); // exits system
		}
		else if(scan.nextLine().equals("show commands")){  // shows all available commands to the user
		    String[] commands = {"view: shows list of your contacts in alphabetical order","add contact: adds a contact to your list of contacts","stop: exits the program"};
            		for(String a: commands){
                		System.out.println(a);
            		}
				}	
    	}
}
