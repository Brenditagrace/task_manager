import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {

	private static Time currentDateTime = null;
	private static List<TaskTimeConstrained> timeConstraintTaskList = new ArrayList<TaskTimeConstrained>();
	private static List<TaskIndependent> independentTaskList = new ArrayList<TaskIndependent>();
	private static List<TaskDependent> dependentTaskList = new ArrayList<TaskDependent>();

	public void addTimeConstrainedTask(TaskTimeConstrained task) {
		timeConstraintTaskList.add(task);
	}

	public void addIndependentTask(TaskIndependent task) {
		independentTaskList.add(task);
	}

	public void addDependentTask(TaskDependent task) {
		dependentTaskList.add(task);
	}

	public void listAllTasks() {
		for (TaskTimeConstrained tCT : timeConstraintTaskList) {
			System.out.println("UniqueTaskID:" + tCT.getUniqueId() + " dateTime:" + tCT.getDateTime().toString()
					+ " Status:" + tCT.getStatus().toString() + "Description:" + tCT.getDescription());
		}
		for (TaskIndependent tCT : independentTaskList) {
			System.out.println("UniqueTaskID:" + tCT.getUniqueId() + " dateTime:" + tCT.getDateTime().toString()
					+ " Status:" + tCT.getStatus().toString() + "Description:" + tCT.getDescription());
		}
		for (TaskDependent tCT : dependentTaskList) {
			System.out.println("UniqueTaskID:" + tCT.getUniqueId() + " dateTime:" + tCT.getDateTime().toString()
					+ " Status:" + tCT.getStatus().toString() + "Description:" + tCT.getDescription()
					+ " Dependency on Task#:" + tCT.getDependency());
		}
	}

	public void updateStatusById(StatusTask task, int id) {
		for (TaskTimeConstrained tCT : timeConstraintTaskList) {
			if (tCT.getUniqueId() == id)
				tCT.setStatus(task);
		}
		for (TaskIndependent tCT : independentTaskList) {
			if (tCT.getUniqueId() == id)
				tCT.setStatus(task);

		}
		for (TaskDependent tCT : dependentTaskList) {
			if (tCT.getUniqueId() == id)
				tCT.setStatus(task);

		}

	}

	public void listAllTasks(StatusTask task) {
		for (TaskTimeConstrained tCT : timeConstraintTaskList) {
			if (task == tCT.getStatus())
				System.out.println("UniqueTaskID:" + tCT.getUniqueId() + " dateTime:" + tCT.getDateTime().toString()
						+ " Status:" + tCT.getStatus().toString() + "Description:" + tCT.getDescription());
		}
		for (TaskIndependent tCT : independentTaskList) {
			if (task == tCT.getStatus())
				System.out.println("UniqueTaskID:" + tCT.getUniqueId() + " dateTime:" + tCT.getDateTime().toString()
						+ " Status:" + tCT.getStatus().toString() + "Description:" + tCT.getDescription());
		}
		for (TaskDependent tCT : dependentTaskList) {
			if (task == tCT.getStatus())
				System.out.println("UniqueTaskID:" + tCT.getUniqueId() + " dateTime:" + tCT.getDateTime().toString()
						+ " Status:" + tCT.getStatus().toString() + "Description:" + tCT.getDescription()
						+ " Dependency on Task#:" + tCT.getDependency());
		}
	}

	public TaskManager() {

		String date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());
		currentDateTime = new Time(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1]),
				Integer.parseInt(date.split("-")[2]), Integer.parseInt(date.split("-")[3]),
				Integer.parseInt(date.split("-")[4]), Integer.parseInt(date.split("-")[5]));
	}

	public Time getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(Time currentDateTime) {
		TaskManager.currentDateTime = currentDateTime;
	}

}
