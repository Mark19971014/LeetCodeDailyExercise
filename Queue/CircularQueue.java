package Queue;

public class CircularQueue {
	 private int[] queue;
	    private int head;
	    private int count;
	    private int size;
	    
	    public CircularQueue(int k) {
	        this.size = k;
	        this.count = 0;
	        this.queue = new int[k];
	        this.head = 0;
	        
	    }
	    
	    public boolean enQueue(int value) {
	        if(isFull()){
	            return false;
	        }
	        queue[(head + count) % size] = value;
	        count++;
	        return true;
	    }
	    
	    public boolean deQueue() {
	        if(isEmpty()){
	            return false;
	        } 
	        head = ( head + 1 ) % size;
	        count--;
	        return true;
	    }
	    
	    public int Front() {
	        if (count == 0)
	            return -1;
	        return queue[head];
	    }
	    
	    public int Rear() {
	        if (count == 0)
	            return -1;
	       int rear = (head + count -1) % size; 
	        return queue[rear];
	    }
	    
	    public boolean isEmpty() {
	        return count == 0;
	    }
	    
	    public boolean isFull() {
	        return count == size;
	    }
}
