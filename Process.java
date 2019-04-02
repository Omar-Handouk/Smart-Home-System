package operatingSystems;

public class Process implements Runnable, Comparable<Process> {

	// process control block
	// identification
	int processID;
	
	// state info

	int interrupt; // if 1 interrupt is enabled 0 is disabled

	// control info

	ProcessState state; // NEW, READY, RUNNING, BLOKED, OR TERMINATED
	int priority; // the higher, the more important

	private int memoryNeeded;

	public Process(int processID, int interrupt, int priority, int memoryNeeded) {
		this.processID = processID;
		this.priority = priority;
		this.state = ProcessState.READY;
		this.interrupt = interrupt;
		this.memoryNeeded = memoryNeeded;
	}

	public int getMemoryNeeded() {
		return memoryNeeded;
	}

	public void setMemoryNeeded(int memoryNeeded) {
		this.memoryNeeded = memoryNeeded;
	}

	public int getProcessID() {
		return processID;
	}

	public void setProcessID(int processID) {
		this.processID = processID;
	}

	public int getInterrupt() {
		return interrupt;
	}

	public void setInterrupt(int interrupt) {
		this.interrupt = interrupt;
	}

	public ProcessState getState() {
		return state;
	}

	public void setState(ProcessState state) {
		this.state = state;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Process o) {
		if (this.priority > o.priority)
			return 1;
		else if (this.priority < o.priority)
			return -1;
		return 0;
	}

}