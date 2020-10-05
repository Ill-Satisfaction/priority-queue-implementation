import java.util.Random;

/**
 * 
 * @author akiahtullis
 * creates processes on demand, according to a determined probability value
 *
 */
public class ProcessGenerator {
	private double probability;
	Random rand;
	
	public ProcessGenerator (double probability) {
		this.probability = probability;
		rand = new Random();
	}
	
	public boolean query () {
		return rand.nextDouble()<probability;
	}
	
	public Process getNewProcess (int currentTime, int maxProcessTime, int maxLevel) {
		return new Process(currentTime, (int)(Math.ceil(maxProcessTime*rand.nextDouble())), (int)(Math.ceil(maxLevel*rand.nextDouble())));
	}
}
