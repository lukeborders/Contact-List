public class Contact extends ContactList {
	private String name;
	private long pNum;
	public Contact(String n,long p) {
		name = n;
		pNum = p;
	}
	public String getName() {
		return name;
	}
	public long getPhoneNumber(){
		return pNum;
	} 
	public void setName(String n) {
		name = n;
	}
	public void setPhoneNumber(long p) {
		pNum =p;
	}
	public String toString() {
        return "Contact Name: " + name + "" + " Contact Phone Number: " + pNum;
    }
}
