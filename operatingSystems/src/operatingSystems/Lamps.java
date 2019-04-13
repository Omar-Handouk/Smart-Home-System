package operatingSystems;

import java.awt.Color;

public class Lamps extends ElectricDevice {
	boolean on;
	private double watt_hour;
	private Color c;

	public Lamps(boolean on, int watt_hour, Color c) {
		this.setWatt_hour(watt_hour);
		this.on = on;
		this.setC(c);

	}

	public double getWatt_hour() {
		return watt_hour;
	}

	public void setWatt_hour(int watt_hour) {
		this.watt_hour = watt_hour;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
}
