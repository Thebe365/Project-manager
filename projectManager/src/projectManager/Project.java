package projectManager;
import java.util.Date;

public class Project {
	
	private String projectName;
	private String projectType;
	private String projectAddress;
	private int erfNum;
	private float totalCost;
	private float totalPaid;
	private Date projectDeadline;
	private boolean isComplete = false;
	private Date completionDate;

	public Project(String projectName, String projectType,
					String projectAddress, int erfNum, float totalCost, float totalPaid, Date date1) {
		
		this.projectName = projectName;
		this.projectType = projectType;
		this.projectAddress = projectAddress;
		this.erfNum = erfNum;
		this.totalCost = totalCost;
		this.totalPaid = totalPaid;
		this.projectDeadline = date1;
		
	}
	
	// Getter methods
	public String getProjectName() {
		return projectName;
	}
	
	public String getProjectType() {
		return projectType;
	}
	
	public String getProjectAddress() {
		return projectAddress;
	}
	
	public int getErfNum() {
		return erfNum;
	}
	
	public float getTotalCost() {
		return totalCost;
	}
	
	public float getTotalPaid() {
		return totalPaid;
	}
	
	public Date getProjectDeadline() {
		return projectDeadline;
	}
	
	
	public boolean getIsComplete() {
		return isComplete;
	}
	
	public Date getCompletionDate() {
		return completionDate;
	}
	
	// Setter methods
	public void setDate(Date newDeadline) {
		this.projectDeadline = newDeadline;
	}
	
	public void setTotalToPay(float payUpdate) {
		this.totalPaid = payUpdate;
	}
	
	public void setIsComplete(boolean comp) {
		this.isComplete = comp;
	}
	
	public void setCompletionDate(Date compDate) {
		this.completionDate = compDate;
	}
	
	// To string method
	public String toString() {
		
		String output = "Project name: " + projectName;
		output += "\nProject type: " + projectType;
		output += "\nProject address: " + projectAddress;
		output += "\nErf num: " + erfNum;
		output += "\nTotal cost: R" + totalCost;
		output += "\nTotal paid: R" + totalPaid;
		output += "\nProject deadline: " + projectDeadline;
		
		return output;
	}
	
}
