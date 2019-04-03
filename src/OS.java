package operatingSystems;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OS implements Runnable {

	ArrayList<ElectricDevice> electricDev = new ArrayList<>();
	static LocalDateTime start;
	static LocalDateTime end;
	static double consuption;
	static double diffrenceInHours;
	static int pid = 0;
	final static int memoryCapacity = 100;
	static int freeMemorySlots = 300;
	boolean ProcessTerminated = true;
	private double powerConsumptionLimit = 60;
	private static double totalPowerConsumption = 0;
	static private ArrayList<Process> processList = new ArrayList<>(); // One Instruction per cell. 32 * 100 bits,
	static Process liveProcess = null; // <bool, int, int> =
	static private HashMap<Integer, Integer> processLocation; // <PID, Location Of First Cell>
	private static ArrayList<Process> blockedProcess = new ArrayList<>();

	public OS() {
		processLocation = new HashMap<>();
		processList = new ArrayList<>();
		setBlockedProcess(new ArrayList<>());
	}

	public int getfreeMemorySlots() {
		return freeMemorySlots;
	}

	public void useMemorySlots(int cells) {
		freeMemorySlots -= cells;
	}

	public void freeMemorySlots(int cells) {
		freeMemorySlots += cells;
	}

	public static double getpowerConsumption() {
		double processConsumption = diffrenceInHours * consuption;
		totalPowerConsumption += processConsumption;
		return processConsumption;
	}

	public void addProcess(Process process) {
		if (liveProcess == null) {
			int neededMemory = process.getMemoryNeeded();
			if (neededMemory <= this.getfreeMemorySlots()) {
				ProcessTerminated = false;
				liveProcess = process;
				start = LocalDateTime.now();
				useMemorySlots(neededMemory);
				process.setProcessID(pid);
				processList.add(process);
				process.state = ProcessState.RUNNING;
				pid++;
			}
		} else {
			processList.add(process);
		}
	}

	public void terminateProcess(Process process) {
		end = LocalDateTime.now();
		process.state = ProcessState.BLOCKED;
		liveProcess = null;
		int neededMemory = process.getMemoryNeeded();
		freeMemorySlots(neededMemory);
		int index = processList.indexOf(process);
		processList.remove(index);
		diffrence();
		if (process instanceof Lightson) {
			consuption = ((Lightson) process).getConsumption();
		}
		if (process instanceof heaterOn) {
			consuption = ((heaterOn) process).getConsumption();
		}
		getpowerConsumption();
		if (!processList.isEmpty()) {
			addProcess(processList.get(0));
		}

	}

	public void diffrence() {
		long diff1 = ChronoUnit.MINUTES.between(start, end);
		long diff2 = ChronoUnit.HOURS.between(start, end);
		long diff3 = ChronoUnit.SECONDS.between(start, end);
		diffrenceInHours = diff2 + (diff1 / 60) + (diff3 / 3600);
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

	public static ArrayList<Process> getBlockedProcess() {
		return blockedProcess;
	}

	public static void setBlockedProcess(ArrayList<Process> blockedp) {
		blockedProcess = blockedp;
	}

	public static void main(String[] args) {
		Process p1 = new Process(1, 1, 1, 20);

		p1.state = ProcessState.RUNNING;

		Process p2 = new Process(3, 3, 3, 20);
		p2.state = ProcessState.RUNNING;
		Process p3 = new Process(2, 2, 2, 20);
		OS o = new OS();
		o.addProcess(p1);
		o.addProcess(p2);
		o.addProcess(p3);
		o.runningProcesses();
		// System.out.println(Arrays.toString(o.runningProcesses().toArray()));
		LocalDateTime starts = LocalDateTime.now();
		LocalDateTime ends = LocalDateTime.now();
		long diff = ChronoUnit.MINUTES.between(starts, ends);
		long diff2 = ChronoUnit.HOURS.between(starts, ends);
		long diff3 = ChronoUnit.SECONDS.between(starts, ends);
		System.out.println(diff + "" + diff2 + "" + diff3);
	}

	@Override
	public void run() {
		while (true) {
			if (!ProcessTerminated) {
				end = LocalDateTime.now();
				diffrence();
				if (getpowerConsumption() > powerConsumptionLimit) {
					terminateProcess(liveProcess);
				}
			}
		}

	}

}
