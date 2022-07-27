package stepFirst;

import java.util.ArrayList;
import java.util.List;

public class FactorCalculation {
	public static void main(String[] args) {
		System.out.println(new FactorCalculation().solution(24, 27));
	}

	public int solution(final int left, final int right) {
		int answer = 0;
		for (int n = left; n <= right; n++) {
			if ((getFactors(n).size() % 2) == 0) {
				answer += n;	
			}else
				answer -= n;
		}
		return answer;
	}
	private List<Integer> getFactors(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if ((n % i) == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
}
