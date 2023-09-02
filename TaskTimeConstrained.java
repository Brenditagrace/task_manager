
public class TaskTimeConstrained extends Task{
	Time dateTime=new Time(-1, -1, -1, -1, -1, -1);

	
	public TaskTimeConstrained( String description, StatusTask status, Time dateTime2) {
		super(null , description, status);
		dateTime = dateTime2;
	}
	
	public TaskTimeConstrained( String description, StatusTask status, Time dateTime2,int uniqueId) {
		super(null , description, status, uniqueId);
		dateTime = dateTime2;
	}
	
	public Time getDateTime() {
		return dateTime;
	}

	public void setDateTime(Time dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "[dateTime=" + dateTime.toString() + "]";
	}
	

}
