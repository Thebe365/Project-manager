package projectManager;

public class Invoice {
	
	int customerPhoneNumber;
	float outstandingAmount;
	
	public Invoice(int customerPhoneNumber, float outstandingAmount) {

		this.customerPhoneNumber = customerPhoneNumber;
		this.outstandingAmount = outstandingAmount;
	}
	
	public String toString() {
		String output = "Customer number: " + customerPhoneNumber;
		output += "\nOutstanding amount: R" + outstandingAmount;
		return output;
	}
}
