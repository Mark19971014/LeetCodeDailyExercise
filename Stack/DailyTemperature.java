package Stack;

import java.util.Stack;

public class DailyTemperature {
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] answer = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int index = stack.pop();
				answer[index] = i - index;
			}
			stack.push(i);
		}

		return answer;
	}
}
