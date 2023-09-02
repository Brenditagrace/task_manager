
public class TaskDependent extends Task {
	public int dependency;
	public TaskDependent(Date dateTime, String description, StatusTask status,int dependency) {
		super(dateTime, description, status);
		if(dependency==-1)
			this.dependency=this.getUniqueId();
		else
		this.dependency=dependency;
	}
	
	
	public TaskDependent(Date dateTime, String description, StatusTask status,int dependency,int uniqueId) {
		super(dateTime, description, status,uniqueId);
		if(dependency==-1)
			this.dependency=this.getUniqueId();
		else
		this.dependency=dependency;
	}
	
	
	public int getDependency() {
		return dependency;
	}
	public void setDependency(int dependency) {
		this.dependency = dependency;
	}

}
