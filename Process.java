
public class Process implements Comparable<Process> {
	
	private int priority;
	private int timeRemaining;
	private int arrivalTime;
	private int timeNotProcessed;
	
	private boolean isFinished;
	
	public Process (int arrivalTime, int maxProcessTime, int maxLevel) {
		this.priority  = (int) Math.ceil(maxLevel*Math.random());
		this.timeRemaining = (int) Math.ceil(maxProcessTime*Math.random());
		this.arrivalTime = arrivalTime;
		this.timeNotProcessed =0;
	}
	
	public void reduceTimeRemaining () {
		timeRemaining--;
		isFinished = (timeRemaining==0);
	}
	
	public boolean finish () {return isFinished;}
	
	public void increasePriority () {priority++;}
	public void increaseTimeNotProcessed () {timeNotProcessed++;}
	public void resetTimeNotProcessed () {this.timeNotProcessed =0;}
	
	public int getArrivalTime () {return this.arrivalTime;}
	public int getTimeRemaining () {return this.timeRemaining;}
	public int getPriority () {return this.priority;}
	public int getTimeNotProcessed () {return this.timeNotProcessed;}

	@Override
	public int compareTo(Process p) {
		if(priority==p.getPriority())
			return (arrivalTime<p.getArrivalTime()) ? 1 : -1 ;
		return (priority>p.getPriority()) ? 1 : -1 ;
	}
}