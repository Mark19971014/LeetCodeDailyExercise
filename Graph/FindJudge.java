package Graph;

public class FindJudge {
	 public int findJudge(int n, int[][] trust) {
	        int[] isTrust = new int[n + 1];
	       
	        for (int[] person : trust){
	            isTrust[person[0]]--;
	            isTrust[person[1]]++;
	        }
	        for (int i = 1; i < isTrust.length; i++){
	            if(isTrust[i] == n - 1){
	                return i;
	            }
	        }
	    return - 1;
	    }
}
