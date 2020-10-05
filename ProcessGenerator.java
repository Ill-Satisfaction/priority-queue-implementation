/**
 * 
 * @author akiahtullis
 * creates processes on demand, according to a determined probability value
 *
 */
public class ProcessGenerator {
	private double probability;
	
	public ProcessGenerator (double probability) {
		this.probability = probability;
	}
	
	public boolean query () {
		return Math.random()<=probability;
	}
	
	public Process getNewProcess (int currentTime, int maxProcessTime, int maxLevel) {
		return new Process(currentTime, maxProcessTime, maxLevel);
	}
}
