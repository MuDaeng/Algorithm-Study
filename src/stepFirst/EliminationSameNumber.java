package stepFirst;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EliminationSameNumber {
	public static void main(String[] args) {
		
	}
	public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int index : arr) {
			if(stack.isEmpty() || !(stack.peek() == index)) {
				stack.push(index);
			}else {
				continue;
			}
		}
		Collections.<Integer>reverse(stack);
		int[] result = new int[stack.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = stack.pop();
		}
		return result;
	}
}
