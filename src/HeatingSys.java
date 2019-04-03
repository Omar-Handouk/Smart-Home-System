package operatingSystems;

public class HeatingSys {
	private double temprature;
	private double watt_Hour;

	public HeatingSys(double temp, double watt_hour) {
		this.setTemprature(temp);
		this.setWatt_Hour(watt_hour);
	}

	public double getWatt_Hour() {
		return watt_Hour;
	}

	public void setWatt_Hour(double watt_Hour) {
		this.watt_Hour = watt_Hour;
	}

	public double getTemprature() {
		return temprature;
	}

	public void setTemprature(double temprature) {
		this.temprature = temprature;
	}

}
