
public class Time extends Date {
	private int hour = 0;
	private int minute = 0;
	private int second = 0;

	
	public Time(int year, int month, int day, int hour, int minute, int second) {
		super(year, month, day);
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}


	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	
}
