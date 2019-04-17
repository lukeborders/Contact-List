import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
public class ContactList {
    private String name;
    private int pNum;

    public static void main(String[] args) {
        System.out.println("Welcome to the Contact organizer. Please type <show commands> to view a list of possible commands");
        String c1 = "";
        long c2 = 0;
        Scanner scan = new Scanner(System.in); // new scanner object
        ArrayList<Contact> list = new ArrayList<>();// new arraylist
        String command = scan.nextLine();
        String[] commands = {"view: shows list of your contacts in alphabetical order", "add contact: adds a contact to your list of contacts", "edit: allows the user to edit a specified contact", "stop: exits the program"};
        String[] contacts = {}; //new array of type String
        int editNum = 0;
        String newnumstring = "";
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        ArrayList<Character> numberList = new ArrayList<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));
        String formattedInt = "";
        while (!command.equals("stop")) {
            if (command.equals("add contact")) {
                System.out.println("Please Input the contact name:");
                c1 = scan.nextLine();
                for (int i = 0; i < c1.length(); i++) {
                    if (!alphabet.contains(c1.charAt(i))) {
                        System.out.println('\n' + "Invalid Input: unexpected character c1");
                    }
                    break;
                }
                System.out.println("Please Input the Contact Phone Number:");
                c2 = scan.nextLong();
                newnumstring = String.valueOf(c2);
                if (String.valueOf(c2).length() != 10) {
                    System.out.println('\n' + "Invalid Input: Phone Number must be 10 numbers");
                } else {
                    for (int m = 0; m < newnumstring.length(); m++) {
                        if (!numberList.contains(newnumstring.charAt(m))) {
                            System.out.println("Invalid Input: unexpected character c2");
                        }
                        break;
                    }
                    Contact newContact = new Contact(c1, c2); // create new contact to add to the ArrayList
                    list.add(newContact);
                    System.out.println('\n' + "Contact Successfully Added");

                }

            } else if (command.equals("view")) {

                contacts = new String[list.size()];
                if (list.size() > 0) {
                    Collections.sort(list, new ContactCompare());
                    for (int i = 0; i < list.size(); i++) { //loops through the entire size of list (in list elements)
                        contacts[i] = "#" + Integer.toString(i) + " " + list.get(i).toString();
                    }
                    for (String a : contacts) {
                        System.out.println(a); //prints every element in contacts[]
                    }
                } else {
                    System.out.println('\n' + "You need to create a contact in your list before you can do this.");
                }

            } else if (command.equals("show commands")) {  // shows all available commands to the user
                for (String a : commands) {
                    System.out.println(a);
                }
            } else if (command.equals("edit")) {
                c1 = "";
                c2 = 0;
                contacts = new String[list.size()];
                for (int g = 0; g < list.size(); g++) { //loops through the entire size of list (in list elements)
                    contacts[g] = "#" + Integer.toString(g) + " " + list.get(g).toString();
                }
                if (list.size() > 0) {
                    System.out.println("Please select the number contact you want to edit:");
                    for (String b : contacts) {
                        System.out.println(b); //prints every element in contacts[]
                    }
                    editNum = scan.nextInt(); scan.nextLine();
                    System.out.println("Please Input the new contact name:");
                    c1 = scan.nextLine();
                    for (int i = 0; i < c1.length(); i++) {
                        if (!alphabet.contains(c1.charAt(i))) {
                            System.out.println('\n' + "Invalid Input: unexpected character c1");
                        }
                        break;
                    }
                    System.out.println("Please Input the new Contact Phone Number:");
                    c2 = scan.nextLong();
                    newnumstring = String.valueOf(c2);
                    if (String.valueOf(c2).length() != 10) {
                        System.out.println('\n' + "Invalid Input: Phone Number must be 10 numbers");
                    } else {
                        for (int m = 0; m < newnumstring.length(); m++) {
                            if (!numberList.contains(newnumstring.charAt(m))) {
                                System.out.println("Invalid Input: unexpected character c2");
                            }
                            break;
                        }
                        list.set(editNum, new Contact(c1, c2));
                        System.out.println('\n' + "Your new contact information is: " + '\n' + '#' + editNum + " Contact Name: " + c1 + " Contact Phone Number: " + c2);
                    }
                } else {
                    System.out.println('\n' + "You need to add a contact to your list");
                }
            }
            //System.out.println('\n' + "Enter Command:");
            command = scan.nextLine();
        }
        System.exit(0);
    }
}
