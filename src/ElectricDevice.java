package operatingSystems;



import java.sql.Date;

public abstract class ElectricDevice {
	
	
	static int electricDeviceID;
	
	boolean on;
	int powerConsumption;
	
	int onFor; //Duration that the device is on for
	Date timeoftheday; //to determine what is on on which times of the day, to be used in turning off lights in the morning
	
	
	
	public int getOnFor() {
		return onFor;
	}
	public void setOnFor(int onFor) {
		this.onFor = onFor;
	}
	public Date getTimeoftheday() {
		return timeoftheday;
	}
	public static int getElectricDeviceID() {
		return electricDeviceID;
	}
	public static void setElectricDeviceID(int electricDeviceID) {
		ElectricDevice.electricDeviceID = electricDeviceID;
	}
	public int getPowerConsumption() {
		return powerConsumption;
	}
	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}
	public void setTimeoftheday(Date timeoftheday) {
		this.timeoftheday = timeoftheday;
	}

	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}

}
