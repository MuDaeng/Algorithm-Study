package stepFirst;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumList {
	public static void main(String[] args) {
		int[] input1 = { 2, 1, 3, 4, 1 };
		int[] numbers = new SumList().solution(input1);
		for (int num : numbers) {
			System.out.print(num + "\t");
		}
	}

	public int[] solution(int[] numbers) {
		Set<Integer> sumList = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				sumList.add(numbers[i] + numbers[j]);
			}
		}
		int[] answer = new int[sumList.size()];
		Object[] sumListObjArr = sumList.toArray();
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (Integer) sumListObjArr[i];
		}
		Arrays.sort(answer);
		return answer;
	}
}
