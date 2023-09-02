
public class TaskIndependent extends Task{

	public TaskIndependent(Date dateTime, String description, StatusTask status) {
		super(dateTime, description, status);
		
	}
	
	
	public TaskIndependent(Date dateTime, String description, StatusTask status,int uniqueId) {
		super(dateTime, description, status, uniqueId);
		
	}
}
