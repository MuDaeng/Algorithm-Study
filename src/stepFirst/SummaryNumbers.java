package stepFirst;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SummaryNumbers {
	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		System.out.println(new SummaryNumbers().solution(absolutes, signs));
	}
	public int solution(int[] absolutes, boolean[] signs) {
		int sum = 0;
		for(int i = 0; i < absolutes.length; i++) {
			sum += signs[i] ? absolutes[i] : -absolutes[i];
		}
		return sum;
	}
}
