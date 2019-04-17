public class Contact extends ContactList {
	private String name;
	private int pNum;
	public Contact(String n,int p) {
		name = n;
		pNum = p;
	}
	public String getName() {
		return name;
	}
	public int getPhoneNumber(){
		return pNum;
	} 
	public void setName(String n) {
		name = n;
	}
	public void setPhoneNumber(int p) {
		pNum =p;
	}
	public String toString() {
        return "Contact Name: " + name + "Contact Phone Number: " + pNum;
    }
}
