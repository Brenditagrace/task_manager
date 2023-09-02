import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		int mainMenu = -1;
		Scanner sc = new Scanner(System.in);
		while (mainMenu != 0) {

			System.out.println("Please enter the number for following options");
			System.out.println("0) Exit");
			System.out.println("1) Create a new task");
			System.out.println("2) Change the current date and time");
			System.out.println("3) Mark a task as complete");
			System.out.println("4) Report tasks ");

			mainMenu = sc.nextInt();

			switch (mainMenu) {
			case 0:
				break;

			case 1: {
				System.out.println("Please enter the number for following options");
				System.out.println("1) Create a Time Constaraint task");
				System.out.println("2) Create a Dependent task");
				System.out.println("3) Create a Independent task");
				System.out.println("Any other then that to go back to main menu");

				int taskOption = sc.nextInt();

				switch (taskOption) {
				case 1:
					System.out.println("Please Enter Description For task");
					String des = sc.nextLine();
					System.out.println(
							"Please enter year month day hour minute in format like \"yyyy MM DD HH mm hh \" for Time contraint task");

					try {
						String date = sc.nextLine();
						Time time = new Time(Integer.parseInt(date.split(" ")[0]), Integer.parseInt(date.split(" ")[1]),
								Integer.parseInt(date.split(" ")[2]), Integer.parseInt(date.split(" ")[3]),
								Integer.parseInt(date.split(" ")[4]), Integer.parseInt(date.split(" ")[5]));
						TaskTimeConstrained tCT = new TaskTimeConstrained(des, StatusTask.NotStarted, time);
						taskManager.addTimeConstrainedTask(tCT);
					} catch (Exception e) {
						System.out.println("Invalid date or Format, Date not updated");
					}

					break;
				case 2:
					// Case of dependent Task:
					try {
						taskManager.listAllTasks();
						int dependency = -1;
						System.out.println(
								"Please Enter Unique Id for Dependent task or hit enter to make it dependent on it self");
						des = sc.nextLine();
						if (!des.equals("")) {
							dependency = Integer.parseInt(des);
						}
						System.out.println("Please Enter Description For Dependent task");
						des = sc.nextLine();
						System.out.println(
								"Please enter year month day hour minute in format like \"yyyy MM DD\" for Time contraint task");

						String date = sc.nextLine();
						Date time = new Date(Integer.parseInt(date.split(" ")[0]), Integer.parseInt(date.split(" ")[1]),
								Integer.parseInt(date.split(" ")[2]));
						TaskDependent tCT = new TaskDependent(time, des, StatusTask.NotStarted, dependency);
						taskManager.addDependentTask(tCT);
						System.out.println("Sucessfully added new Dependent Task");
					} catch (Exception e) {
						System.out.println("Something went wrong please try again");
					}

					break;
				case 3:
					try {

						System.out.println("Please Enter Description For Independent task");
						des = sc.nextLine();
						System.out.println(
								"Please enter year month day hour minute in format like \"yyyy MM DD\" for Time contraint task");

						String date = sc.nextLine();
						Date time = new Date(Integer.parseInt(date.split(" ")[0]), Integer.parseInt(date.split(" ")[1]),
								Integer.parseInt(date.split(" ")[2]));
						TaskIndependent tCT = new TaskIndependent(time, des, StatusTask.NotStarted);
						taskManager.addIndependentTask(tCT);
						System.out.println("Sucessfully added new Independent Task");
					} catch (Exception e) {
						System.out.println("Something went wrong please try again");
					}

					break;
				default:
					break;
				}
			}
				break;
			case 2: {
				System.out.println("Please enter year month day hour minute in format like \"yyyy MM DD HH mm hh \"");

				try {
					String date = sc.nextLine();
					taskManager.setCurrentDateTime(
							new Time(Integer.parseInt(date.split(" ")[0]), Integer.parseInt(date.split(" ")[1]),
									Integer.parseInt(date.split(" ")[2]), Integer.parseInt(date.split(" ")[3]),
									Integer.parseInt(date.split(" ")[4]), Integer.parseInt(date.split(" ")[5])));

				} catch (Exception e) {
					System.out.println("Invalid date or Format, Date not updated");
				}
			}

			case 3: {

				taskManager.listAllTasks(StatusTask.Started);
				taskManager.listAllTasks(StatusTask.NotStarted);
				System.out.println("select and enter unique id of any of above Tasks to mark it complete");

				int taskUniqueId = sc.nextInt();
				taskManager.updateStatusById(StatusTask.Completed, taskUniqueId);
			}
				break;
			case 4: {
				taskManager.listAllTasks();

			}
				break;
			default:
				break;
			}

		}
	}
}
