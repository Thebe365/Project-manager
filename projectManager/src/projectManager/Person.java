package projectManager;

public class Person {
	
	private String name;
	private String surname;
	private int phoneNumber;
	private String emailAddress;
	private String physicalAddress;
	
	public Person(String name, String surname, int phoneNumber, String emailAddress, String physicalAddress) {
		
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}
	
	// Getter methods
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	
	// Setter methods
	public void setPhoneNumber(int num) {
		this.phoneNumber = num;
	}
	
	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}
	
	public String toString() {
		String output = "Name: " + name;
		output += "\nSurname: " + surname;
		output += "\nPhone number: " + phoneNumber;
		output += "\nEmail: " + emailAddress;
		output += "\nPhysical address: " + physicalAddress;
		
		return output;
	}
}
