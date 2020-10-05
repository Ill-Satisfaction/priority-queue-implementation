/**
 * @author akiahtullis
 * max heap implementation for holding processes
 */

public class MaxHeap {
	
	private Process[] heap;
	private int tail;
	
	
	
	
	
	public MaxHeap () {
		heap = new Process[200];
		tail = 0;
	}
	
	
	
	
	
	// push - insert new
	public void push (Process p) {
		if (tail==heap.length-1) expandArray();
		heap[tail] = p;
		siftUp(tail);
		tail++;
	}
	
	// pop - extract max
	public Process pop () {
		if (!isEmpty()) {
			Process retVal = heap[0];
			if (tail>0) heap[0] = heap[tail-1];
			heap[tail] = null;
			tail--;
			siftDown(0);
			incrementNotProcessed();
			return retVal;
		}
		return null;
	}
	
	// size
	public int size () {return tail;}
	
	// is empty
	public boolean isEmpty () {return (tail==0);}
	
	// update -> increments processes that haven't been touched in a while, does not exceed maximum
	public void update(int timeToIncrementLevel, int maxLevel) {
		for (int i=0; i<tail; i++) {
			if (heap[i].getTimeNotProcessed()>=timeToIncrementLevel) {
				if(heap[i].getTimeNotProcessed()<=maxLevel) {
					heap[i].increasePriority();
				}
			}
		}
	}
	
	// sift-up
	public void siftUp (int index) {
		int currIndex = index;
		int parentIndex = (index%2==0) ? (index-1)/2 : index/2;
		while (heap[currIndex].compareTo(heap[parentIndex]) > 0) {
			swap(currIndex, parentIndex);
			currIndex = parentIndex;
			parentIndex = (currIndex%2==0) ? (currIndex-1)/2 : currIndex/2;
		}
	}
	
	// sift-down
	public void siftDown (int index) {
		if(isLeaf(index)) return;
		
		int greaterChild = lChild(index);
		if (lChild(index) < tail) {	// if left child exists
			if (heap[lChild(index)].compareTo(heap[rChild(index)]) < 0) {
				greaterChild = index*2+2;
			}
		}
		if (heap[index].compareTo(heap[greaterChild]) < 0) {
			swap(index, greaterChild);
			index = greaterChild;
			siftDown(greaterChild);
		}
	}
	
	// get
	public Process[] getHeap () {return heap;}
	
	
	// swap
	private void swap (int idx1, int idx2) {
		Process p = heap[idx1];
		heap[idx1] = heap[idx2];
		heap[idx2] = p;
	}
	
	// is leaf -> checks if given index is a leaf
	private boolean isLeaf (int index) {
		return (index >= (tail+1)/2);
	}
	private int lChild (int idx) {return 2*idx+1;}
	private int rChild (int idx) {return 2*idx+2;}
	
	// not Processed -> increments time of all nodes
	private void incrementNotProcessed () {
		for (int i=0; i<tail; i++) {
			heap[i].increaseTimeNotProcessed();
		}
	}
	
	private void expandArray () {
		Process[] tmp = new Process[tail*2];
		for (int i=0; i<tail; i++) {
			tmp[i] = heap[i];
		}
		heap = tmp;
	}
}
