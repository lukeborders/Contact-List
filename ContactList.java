import java.util.Scanner;
import java.util.Collections.sort;
public class ContactList extends Contact {
	public static void main(String[] args) {
		ArrayList<Contact> list = new ArrayList<Contact>(); // new arraylist
		list = Collections.sort(list); 		// sort the arraylist in alphabetical order
	}
	public void viewList(ArrayList<Contact> list,Scanner scanner) {
			if(scanner.nextLine().equals("view")) {
			for(Contact a: list) {
				System.out.println(a);
			} 
		}
	}
	public void addContact(Scanner scanner) {
		//Scanner scanner = new Scanner(System.in); // creates scanner object
		Char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',',','.','\''} 
		if(scanner.nextLine().equals("add contact")) {
			System.out.println("Please Input Name:");
			String n = scanner.nextLine();
			for(int i = 0; i < n.length();i++) {
				for(int m = 0; m < alphabet.length, m++;) {
					if(n.charAt(i) != alphabet[m] ) {
						System.out.println("invalid input, try again:");
						i=n.length();
						n = scanner.nextLine();
					}		
				}
			}
			System.out.println("Please Input Phone Number:");
			int num = scanner.nextInt();
			Contact newContact = new Contact(n,num);
			list.add(newContact);
			Collections.sort(list);
		}
	}
	public static void exit(Scanner scanner) {
		if(scanner.nextLine().equals("stop")) {
			System.exit(0);
		}
	}
}