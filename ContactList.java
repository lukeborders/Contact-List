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
		String command = scan.nextLine();
		String[] commands = {"view: shows list of your contacts in alphabetical order","add contact: adds a contact to your list of contacts","edit: allows the user to edit a specified contact","stop: exits the program"};
		String[] contacts = {}; //new array of type String
        int editNum = 0;
		String newnumstring = "";
		//String formattedInt = "(" + f.substring(0,4) + ")" + "-" + f.substring(3,7) + "-" + f.substring(6,10); // creates a string of the inputted phone number in the format of (###)-###-####
		while(!command.equals("stop")) {
            if (command.equals("add contact")) {
                System.out.println("Please Input the contact name:");
                c1 = scan.nextLine();
                ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
                ArrayList<Integer> numberList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
                for(int i = 0; i < c1.length();i++) {
                	if(!alphabet.contains(c1.charAt(i))) {
                		System.out.println('\n'+"Invalid Input: unexpected character");
                	}
                	break;
                }
                System.out.println("Please Input the Contact Phone Number:");
                c2 = scan.nextInt();
				newnumstring = Integer.toString(c2);
                if(Integer.toString(c2).length() != 10) {
                    System.out.println('\n' + "Invalid Input: Phone Number must be 10 integers");
                }
                else {
                    for(int m = 0; m < newnumstring.length();m++) {
                        if(!numberList.contains(newnumstring.charAt(m))) {
                            System.out.println("Invalid Input: unexpected character");
                        }
                        break;
                    }
                    Contact newContact = new Contact(c1, c2); // create new contact to add to the ArrayList
                    list.add(newContact);
                    System.out.println('\n'+"Contact Successfully Added");
                    
                }
                  
            } else if (command.equals("view")) {
                contacts = new String[list.size()];
                if(list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) { //loops through the entire size of list (in list elements)
                        contacts[i] = "#" + Integer.toString(i) + " " + list.get(i).toString();
                    }
                    for (String a : contacts) {
                        System.out.println(a); //prints every element in contacts[]
                    }
                }
                else {
                 System.out.println('\n'+"You need to create a contact in your list before you can do this.");   
                }
                
            } else if (command.equals("show commands")) {  // shows all available commands to the user
                    for (String a : commands) {
                        System.out.println(a);
                    }
                }
            else if(command.equals("edit")) {
                if(contacts.length < 0) {
                    for (int g = 0; g < list.size(); g++) { //loops through the entire size of list (in list elements)
                        contacts[g] = "#" + Integer.toString(g) + " " + list.get(g).toString();
                    }
                }
                if(list.size() > 0) {
                    System.out.println("Please select the number contact you want to edit:");
                    for (String a : contacts) {
                        System.out.println(a); //prints every element in contacts[]
                    }
                    editNum = scan.nextInt();
				    System.out.println(list.get(editNum).toString());
				    System.out.println("Do you need to edit the username? Y/N");
				    if(command.equals("Y")||command.equals("y")) {
					    System.out.println("Type in new name:");
					    c1= scan.nextLine();
				    }
				    else if(command.equals("N")||command.equals("n")) {
					    System.out.println("Do you need to edit the phone number? Y/N");
					    if(command.equals("Y")||command.equals("y")) {
					    	System.out.println("Type in new phone number");
                            c2 = scan.nextInt();
                            list.set(editNum,new Contact(c1,c2));
                            System.out.println('\n' + "Your new contact information is: " + '\n' + '#' + editNum + "Contact Name: " + c1 + "Contact Phone Number: " + c2 );
					    }
					    else if(command.equals("N")||command.equals("n")) {
						    System.out.println('\n'+"Exiting editor. . .");
					    }
				    }
                    
                }
                else {
                    System.out.println('\n'+"You need to add a contact to your list");
                }
            }
            //System.out.println('\n' + "Enter Command:");
            command = scan.nextLine();
        }
            System.exit(0);
    }
    
}


