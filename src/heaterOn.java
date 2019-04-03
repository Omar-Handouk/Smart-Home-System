package operatingSystems;

public class heaterOn extends Process {
	private HeatingSys x;

	public heaterOn(int processID, int interrupt, int priority, int memoryNeeded, HeatingSys x) {
		super(processID, interrupt, priority, memoryNeeded);
		this.setX(x);
		// TODO Auto-generated constructor stub
	}

	public HeatingSys getX() {
		return x;
	}

	public double getConsumption() {
		return x.getWatt_Hour();
	}

	public void setX(HeatingSys x) {
		this.x = x;
	}

}
