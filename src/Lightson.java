package operatingSystems;

public class Lightson extends Process {
	private Lamps l;

	public Lightson(int processID, int interrupt, int priority, int memoryNeeded, Lamps l) {
		super(processID, interrupt, priority, memoryNeeded);
		this.setL(l);
		// TODO Auto-generated constructor stub
	}

	public Lamps getL() {
		return l;
	}

	public double getConsumption() {
		return l.getWatt_hour();
	}

	public void setL(Lamps l) {
		this.l = l;
	}

}
