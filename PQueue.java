
public class PQueue {
	
	private MaxHeap mh;
	
	public PQueue () {
		mh = new MaxHeap();
	}
	

	public void enPQueue (Process process) {
		mh.push(process);
	}
	
	public Process dePQueue () {
		
		return mh.pop();
	}
	
	public void update (int timeToIncrementLevel, int maxLevel) {
		mh.update(timeToIncrementLevel, maxLevel);
	}
	
	public boolean isEmpty () {
		return mh.isEmpty();
	}
}
