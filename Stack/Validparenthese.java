package Stack;

import java.util.HashMap;
import java.util.Stack;

public class Validparenthese {
	HashMap<Character, Character> mappings = new HashMap<Character, Character>();

	public Validparenthese() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put(']', '[');
		this.mappings.put('}', '{');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (mappings.containsKey(c)) {
				char topElement = stack.isEmpty() ? '#' : stack.pop();
				if (topElement != mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}

		}
		return stack.isEmpty();
	}
}
