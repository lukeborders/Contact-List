import java.util.Scanner;
import java.util.Collections.sort;
public class ContactList extends Contact {
	private String name;
	private int pNum;
		
	public static void main(String[] args) {
		String c1 = "";
		int c2 = 0; 
		Scanner scan = new Scanner(System.in);
		ArrayList<Contact> list;// new arraylist
		sort(list);
		if(scan.nextLine().equals("add contact")) {
			Char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			System.out.println("Please Input the contact name:");
			for(int i = 0; i < na.length();i++) {
				for(int m = 0; m < alphabet.length; m++) {
					if(n.charAt(i) != alphabet[m] ) {
						System.out.println("invalid input, try again:");
						i=na.length();
						na = scan.nextLine();
					}		
				}
			}
			c1 = scan.nextLine();
			c2 = scan.nextInt();
			Contact newContact = new Contact(c1,c2);
			list.add(newContact);
		}
		if(scan.nextLine().equals("view")) {
			for(Contact a: list) {
				System.out.println(a);
			}
		}
		if(scan.nextLine().equals("stop")) {
			System.exit(0);
		}
		
	}
}
