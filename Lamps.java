package operatingSystems;

import java.awt.Color;

public class Lamps extends ElectricDevice{
  boolean on;
  int watt_hour;
  Color c;
  


public Lamps (boolean on, int watt_hour, Color c) {
	this.watt_hour= watt_hour;
	this.on = on;
	this.c = c;
	
	
}
}