
public class ProcessGenerator {
	
	double probability;
	
	
	
	//	CONSTRUCTOR
	public ProcessGenerator (double probability) {
		this.probability = probability;
	}
	
	
	
	//	METHODS
	public boolean query () {
		return (Math.random() <= probability);
	}
	
	public Process getNewProcess (double currentTime, double maxProcessTime, double maxLevel) {
		return new Process(currentTime, maxProcessTime, maxLevel);
	}
	

}
