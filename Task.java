
public class Task {

	private Date dateTime = new Date(-2, -2, -2);
	private String description;
	private StatusTask status;

	private static int objectCounts = 0;
	public int uniqueId;

	public Task(Date dateTime, String description, StatusTask status) {
		super();
		this.dateTime = dateTime;
		this.description = description;
		this.status = status;
		objectCounts++;
		uniqueId = objectCounts;
	}

	public Task(Date dateTime, String description, StatusTask status, int uniqueId) {
		super();
		this.dateTime = dateTime;
		this.description = description;
		this.status = status;
		objectCounts++;
		this.uniqueId = uniqueId;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public StatusTask getStatus() {
		return status;
	}

	public void setStatus(StatusTask status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
