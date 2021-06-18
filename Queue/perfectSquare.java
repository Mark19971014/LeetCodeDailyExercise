package Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class perfectSquare {
	public int numSquares(int n) {
	    Queue<Integer> queue = new LinkedList<>();
	        Set<Integer> visited = new HashSet<>();
	        queue.offer(0);
	        visited.add(0);
	        int count = 1;
	        while(!queue.isEmpty()){
	            
	            int size = queue.size();
	            for (int i = 0; i < size; i++){
	               int top = queue.poll();
	                for (int j = 1; j * j <= n ; j++){
	                   int curr = top +  j*j;
	                
	                if (curr > n){
	                    break;
	                }else if (curr == n){
	                     return count;
	                } else if (!visited.contains(curr)){
	                    queue.offer(curr);
	                    visited.add(curr);
	                }
	              
	                }
	            }
	          count ++;    
	        }
	           return count;
	        
	    }
}
