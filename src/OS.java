package operatingSystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OS {
	
	ArrayList<ElectricDevice> electricDev = new ArrayList<>();
	
	static int pid = 0;
	int nil = 0;
	final static int memoryCapacity = 100;
	static int freeMemorySlots = 300;
	static private ArrayList<Process> processList = new ArrayList<>(); // One Instruction per cell. 32 * 100 bits,
																		// <bool, int, int> =
	static private HashMap<Integer, Integer> processLocation; // <PID, Location Of First Cell>

	
	public OS() {
		this.processLocation = new HashMap<>();
		this.processList = new ArrayList<>();
	}

	
	public int getfreeMemorySlots() {
		return freeMemorySlots;
	}

	
	public void useMemorySlots(int cells) {
		this.freeMemorySlots -= cells;
	}

	
	public void freeMemorySlots(int cells) {
		this.freeMemorySlots += cells;
	}

	
	public void addProcess(Process process) {
		int neededMemory = process.getMemoryNeeded();
		if (neededMemory <= this.getfreeMemorySlots()) {
			useMemorySlots(neededMemory);
			process.setProcessID(pid);
			processList.add(process);
			pid++;

		}
	}

	
	public void terminateProcess(Process process) {
		int neededMemory = process.getMemoryNeeded();
		freeMemorySlots(neededMemory);
		int index = processList.indexOf(process);
		processList.remove(index);

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

//	public static void main(String[] args) {
//		Process p1 = new Process(1, 1, 1, 20);
//
//		p1.state = ProcessState.RUNNING;
//
//		Process p2 = new Process(3, 3, 3, 20);
//		p2.state = ProcessState.RUNNING;
//		Process p3 = new Process(2, 2, 2, 20);
//		OS o = new OS();
//		o.addProcess(p1);
//		o.addProcess(p2);
//		o.addProcess(p3);
//		o.runningProcesses();
//		System.out.println(Arrays.toString(o.runningProcesses().toArray()));
//
//	}

}
