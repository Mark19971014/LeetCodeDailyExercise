package Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

	public String pulsOne(String s, int j){
	        char[] ch = s.toCharArray();
	        if(ch[j] == '9'){
	            ch[j] = '0';
	        }else{
	             ch[j] += 1;
	        }
	        return new String(ch);
	    }

	public String minusOne(String s, int j){
	        char[] ch = s.toCharArray();
	        if(ch[j] == '0'){
	            ch[j] = '9';
	        }else{
	            ch[j] -= 1;
	        }
	        return new String(ch);
	    }

	public int openLock(String[] deadends, String target) {
		Set<String> deadend = new HashSet<>();
		for (String s : deadends) {
			deadend.add(s);
		}
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer("0000");
		visited.add("0000");
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				if (deadend.contains(cur))
					continue;
				if (cur.equals(target))
					return step;
				for (int j = 0; j < 4; j++) {
					String up = pulsOne(cur, j);
					if (!visited.contains(up)) {
						q.offer(up);
						visited.add(up);
					}
					String down = minusOne(cur, j);
					if (!visited.contains(down)) {
						q.offer(down);
						visited.add(down);
					}
				}
			}
			step++;
		}
		return -1;
	}
}
