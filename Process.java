
public class Process implements Comparable<Process>{
	
	private int priority;
	private double arrivalTime;
	private int timeRemaining;
	private int timeNotProcessed;
	
	
	
	
	
	public Process (double arrivalTime, double maxProcessTime, double maxLevel) {
		this.priority = (int) (maxLevel*Math.random());
		this.timeRemaining = (int) Math.ceil(maxProcessTime*Math.random());
		this.arrivalTime = arrivalTime;
		this.timeNotProcessed = 0;
	}
	
	
	
	
	
	public void reduceTimeRemaining () {
		timeRemaining--;
	}
	
	public void resetTimeNotProcessed () {
		this.timeNotProcessed = 0;
	}
	
	public boolean finish () {
		return timeRemaining<=0;
	}
	
	public double getArrivalTime(){ return this.arrivalTime; }
	public int getTimeRemaining(){ return timeRemaining; }
	public int getPriority(){ return this.priority; }
	public int getTimeNotProcessed(){return this.timeNotProcessed; }
	
	public void incrementPriority(){ this.priority++; }
	public void incrementTimeNotProcessed(){ this.timeNotProcessed++;}
	
	@Override
	public int compareTo(Process p) {
		if (this.getPriority()==p.getPriority())
			return (this.getArrivalTime()<p.getArrivalTime()) ? 1 : -1;
		return (this.getPriority()>p.getPriority()) ? 1 : -1 ;
	}

	
}
