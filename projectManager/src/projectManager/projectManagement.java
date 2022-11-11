package projectManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class projectManagement {
	
	static Scanner globalScanner = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		
		// Arrays for each object
		ArrayList<Project> project = new ArrayList<Project>();
		ArrayList<Customer> custArr = new ArrayList<Customer>();
		ArrayList<Architect> archArr = new ArrayList<Architect>();
		ArrayList<Contractor> conArr = new ArrayList<Contractor>();
		ArrayList<Invoice> invoice = new ArrayList<Invoice>();
		
		int projCount = 0;
		int option = 0;
		Scanner userInput = new Scanner(System.in);

		System.out.println("Please select an option: \nAdd new project - 1\nEdit due date - "
							+ "2\nChange paid amount - 3\nUpdate contractor details - 4"
							+ "\nFinalize a project - 5\nView incomplete projects - 6"
							+ "\nSearch for a project - 7\nDisplay projects past due - 8"
							+ "\nQuit - -1");
		
		option = userInput.nextInt();
		
		while(option != -1) {
			
			switch (option) {
				case 1:
					
					// Call the createCustomer method and store in the customer array
					custArr.add(createCustomer()); 

					// Call the create contractor method
					conArr.add(createContractor());
					
					// Call createArchitect method
					archArr.add(createArchitect());
					
					// Call the createProject method and store it in the project array
					 project.add(createProject(custArr.get(projCount).getSurname()));
					 projCount++;
					break;
				case 2:
					
					// Call update date method
					updateDate(project);
					break;
				case 3:
					
					// Call update total paid method
					updateTotalPaid(project);
					break;
				case 4:
					
					// Call update contractor details
					updateContractorDetails(conArr);
					break;
				case 5:
					
					// Check if project array is not empty
					if(project.size() != 0) {
						invoice.add(finalizeProject(project, custArr));
					}else {
						System.out.println("No projects to display!");
					}
					
					break;
				case 6:
					
					// display unfinished projects
					displayUnfinishedProjects(project);
					break;
				case 7:
					
					// Display searched project
					searchProject(project);
					break;
				case 8:
					
					// Display projects past due
					projectsPastDue(project);
					break;
				default:
					System.out.println("Wrong input, try again");
					break;
			}
			
			System.out.println("Please select an option: \nAdd new project - 1\nEdit due date - "
								+ "2\nChange paid amount - 3\nUpdate contractor details - 4"
								+ "\nFinalize a project - 5\nView incomplete projects - 6"
								+ "\nSearch for a project - 7\nDisplay projects past due - 8"
								+ "\nQuit - -1");
			
			option = userInput.nextInt();

		}
		
		// Close scanner
		userInput.close();
	}
	
	// Create project method that returns an object 
	public static Project createProject(String custSurname) throws ParseException {
		
		// Prompt user to enter information about a project
		System.out.println("Enter project name please: ");
		String projectName = globalScanner.nextLine();
		System.out.println("Enter project type E.g house, Apartment: ");
		String projectType = globalScanner.nextLine();
		System.out.println("Enter project physical address: ");
		String projectAddress = globalScanner.nextLine();
		System.out.println("Enter ERF number: ");
		int erfNum = Integer.parseInt(globalScanner.nextLine());
		System.out.println("Enter total Price of project: ");
		float totPrice = Float.parseFloat(globalScanner.nextLine());
		System.out.println("Enter total paid to date: ");
		float totPaid = Float.parseFloat(globalScanner.nextLine());
		System.out.println("Enter deadline date (yyyy-MM-DD): ");
		String deadline = globalScanner.nextLine();
		
		// check if project name is entered
		if(projectName.length() == 0) {
			projectName = custSurname + " " + projectType;
		}
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(deadline); 
		// Create new project object
		Project proj = new Project(projectName, projectType, projectAddress,
									erfNum, totPrice, totPaid, date1);
		
		return proj;
	}
	
	public static Customer createCustomer() {
		
		// Prompt user for customer info
		System.out.println("Enter customer name: ");
		String name = globalScanner.nextLine();
		System.out.println("Enter customer surname: ");
		String surname = globalScanner.nextLine();
		System.out.println("Enter customer phone number: ");
		int phoneNumber = Integer.parseInt(globalScanner.nextLine());
		System.out.println("Enter customer email address: ");
		String emailAddress = globalScanner.nextLine();
		System.out.println("Enter customer physical address: ");
		String physicalAddress = globalScanner.nextLine();
		
		Customer cust = new Customer(name, surname, phoneNumber, emailAddress, physicalAddress);
		return cust;
	}
	
	// Create Architect method
	public static Architect createArchitect() {
		
		// Prompt user for architect info
		System.out.println("Enter architect name: ");
		String name = globalScanner.nextLine();
		System.out.println("Enter architect surname: ");
		String surname =  globalScanner.nextLine();
		System.out.println("Enter architect phone number: ");
		int phoneNumber = Integer.parseInt(globalScanner.nextLine());
		System.out.println("Enter architect email address: ");
		String emailAddress = globalScanner.nextLine();
		System.out.println("Enter architect physical address: ");
		String physicalAddress = globalScanner.nextLine();
		
		Architect architect = new Architect(name, surname, phoneNumber, emailAddress, physicalAddress);
		return architect;
	}
	
	//Create Contractor method
	public static Contractor createContractor() {
		
		// Prompt user for contractor info
		System.out.println("Enter contractor name: ");
		String name = globalScanner.nextLine();
		System.out.println("Enter contractor surname: ");
		String surname =  globalScanner.nextLine();
		System.out.println("Enter contractor phone number: ");
		int phoneNumber = Integer.parseInt(globalScanner.nextLine());
		System.out.println("Enter contractor email address: ");
		String emailAddress = globalScanner.nextLine();
		System.out.println("Enter contractor physical address: ");
		String physicalAddress = globalScanner.nextLine();
		
		Contractor con = new Contractor(name, surname, phoneNumber, emailAddress, physicalAddress);
		return con;
	}
	
	//update project deadline date method
	public static void updateDate(ArrayList<Project> proj) throws ParseException {
		
		// Check if array list is not empty
		if(proj.size() != 0) {
			
			// Display projects that have not been finalized
			for(int i = 0; i < proj.size(); i++) {
				
				if(proj.get(i).getIsComplete() == false) {
					
					System.out.println("Project num: " + (i + 1));
					System.out.println(proj.get(i).toString() + "\n");
				}
			}
			
			// Prompt user to  enter project they would like to update
			System.out.println("Enter project you'd like to edit eg 1, 2: ");
			int projInd = Integer.parseInt(globalScanner.nextLine());
			System.out.println("Enter new project deadline (yyyy-MM-dd): ");
			String newDate = globalScanner.nextLine();
			
			// Create new date and update project date
			Date date1 = new SimpleDateFormat("yyy-MM-dd").parse(newDate);
			proj.get(projInd - 1).setDate(date1);
			System.out.println("Deadline date has been updated!");
		}else {
			System.out.print("No projects to display\n");
		}

	}
	
	// Update amount paid method
	public static void updateTotalPaid(ArrayList<Project> proj) {
		
		// Check if array list is not empty
		if(proj.size() != 0) {
			
			// Display projects that have not been finalized
			for(int i = 0; i < proj.size(); i++) {
				
				if(proj.get(i).getIsComplete() == false) {
					
					System.out.println("Project num: " + (i + 1));
					System.out.println(proj.get(i).toString() + "\n");
				}
			}
			
			// Prompt user to  enter project they would like to update
			System.out.println("Enter project you'd like to edit eg 1, 2: ");
			int projInd = globalScanner.nextInt();
			System.out.println("Enter amount paid: R");
			float amount = Float.parseFloat(globalScanner.nextLine());
			
			// Calculate total amount paid
			float total = proj.get(projInd - 1).getTotalPaid() + amount;
			
			// Update amount
			if(total > proj.get(projInd - 1).getTotalCost()) {
				
				System.out.println("How generouse of you, thank you!");
				proj.get(projInd - 1).setTotalToPay(total);
				System.out.println("Amount updated!");
			}else {
				
				proj.get(projInd - 1).setTotalToPay(total);
				System.out.println("Amount updated!");
			}
		}else {
			System.out.print("No projects to display\n");
		}
		
	}
	
	// Update contractor information
	public static void updateContractorDetails(ArrayList<Contractor> con) {
		
		if(con.size() != 0) {
			
			// Display projects that have not been finalized
			for(int i = 0; i < con.size(); i++) {
					
				System.out.println("Contractor: " + (i + 1));
				System.out.println(con.get(i) + "\n");
			}
			
			int option = 0;
			
			// Prompt user to enter contractor
			System.out.println("Enter contractor E.g 1, 2: ");
			int ind = Integer.parseInt(globalScanner.nextLine());
			
			while(option != -1) {
				
				// Prompt user to to make a selection
				System.out.println("What would you like to edit? (-1 to exit)"
						+ "\nPhone number - 1"
						+ "\nEmail Address - 2");
				option = Integer.parseInt(globalScanner.nextLine());
				
				switch (option) {
					case 1:
						
						// Prompt user to enter new phone number
						System.out.println("Enter new phone number: ");
						int phone = Integer.parseInt(globalScanner.nextLine());
						con.get(ind - 1).setPhoneNumber(phone);
						System.out.println("Phone number has been updated");
						break;
					case 2:
						
						// Prompt user to enter new email address
						System.out.println("Enter new email address: ");
						String email = globalScanner.nextLine();
						con.get(ind - 1).setEmailAddress(email);
						break;
					case -1:
						//
						break;
					default:
						System.out.println("Invalid selection!\n");
				}
			}
		}else {
			System.out.println("List is empty!\n");
		}
		
		
	}
	
	// Finalize project method
	public static Invoice finalizeProject(ArrayList<Project> proj, ArrayList<Customer> cust) {
			
		// Display projects that have not been finalized
		for(int i = 0; i < proj.size(); i++) {
			
			if(proj.get(i).getIsComplete() == false) {
				
				System.out.println("Project num: " + (i + 1));
				System.out.println(proj.get(i) + "\n");
			}
		}
		
		// Prompt user to enter project index
		int ind = 0;
		System.out.println("Enter project number: ");
		ind = Integer.parseInt(globalScanner.nextLine());
			
		// finalize project
		proj.get(ind - 1).setIsComplete(true);
		
		// Generate invoice
		float outstandingAmnt = proj.get(ind - 1).getTotalCost() - proj.get(ind - 1).getTotalPaid();
		Invoice inv = new Invoice(cust.get(ind - 1).getPhoneNumber(), outstandingAmnt);
		
		System.out.println("Enter project number: ");
		ind = Integer.parseInt(globalScanner.nextLine());
		
		return inv;

	}
	
	
	// Display unfinished projects
	public static void displayUnfinishedProjects(ArrayList<Project> proj) {
		
		if(proj.size() != 0) {
			
			// Display projects that have not been finalized
			for(int i = 0; i < proj.size(); i++) {
				
				if(proj.get(i).getIsComplete() == false) {
					
					System.out.println("Project num: " + (i + 1));
					System.out.println(proj.get(i) + "\n");
				}
			}
		}else {
			System.out.println("No projects to display");
		}

	}
	
	// Search for a project
	public static void searchProject(ArrayList<Project> proj) {
		
		if(proj.size() != 0) {
			
			boolean isFound = false;
			//Prompt user to enter project number or name
			System.out.println("Please enter project number or name: ");
			String searchQuery = globalScanner.nextLine();
			
			// Search for project
			for(int i = 0; i < proj.size(); i++) {
				
				if(searchQuery.matches(proj.get(i).getProjectName()) || searchQuery.matches(String.valueOf(i + 1))) {
					
					System.out.println("Search result:");
					System.out.println("========================");
					System.out.println(proj.get(i) + "\n");
					isFound = true;
					break;
				}
			}
			
			if(isFound == false) {
				System.out.print("Project not found\n");
			}
		}else {
			
			System.out.println("No projects to display");
		}

		
	}
	
	// Projects past due method
	public static void projectsPastDue(ArrayList<Project> proj) {
		
		// Create a date object
		Date dateObj = new Date();
		int overdueCount = 0;
		// Search and display projects past due
		for(int i = 0; i < proj.size(); i++) {
			
			if(proj.get(i).getIsComplete() == false && proj.get(i).getProjectDeadline().before(dateObj)) {
				
				System.out.println("\nProjects overdue");
				System.out.println("========================");
				System.out.println(proj.get(i) + "\n");
				overdueCount++;
			}
		}
		
		if(overdueCount == 0) {
			System.out.println("No overdue projects found\n");
		}
	}
	
	
}
