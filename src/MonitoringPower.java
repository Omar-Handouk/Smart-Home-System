package operatingSystems;

import java.util.ArrayList;
import java.util.Collections;

public class MonitoringPower implements Runnable {

	private final int threshhold;
	
	private ArrayList<Process> processList;
	
	public int getThreshhold() {
		return threshhold;
	}

	public MonitoringPower(ArrayList<Process> processList) {
		this.threshhold = 2000; // 2000 Watts
		this.processList = processList;
	}

	@Override
	public void run() {
		
		while (true)
		{
			ArrayList<Process> sortedProcess = runningProcesses();
			
			int totalCons = 0;
			
			for (Process process : sortedProcess) {
				
				
			}
		}
	}
	
	public ArrayList<Process> runningProcesses() {
		// we need to sort periodically
		ArrayList<Process> list = new ArrayList<>();
		for (Process p : processList) {
			if (p.state.equals(ProcessState.RUNNING))
				list.add(p);
		}
		Collections.sort(list);
		return list;
	}
}
