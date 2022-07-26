package algorithm;

import java.util.Arrays;

public class ScovilleTest {
	public static void main(String[] args) {
		int[] scoville = {1, 1, 0, 0, 0, 0};
		int K = 7;
		System.out.println(new ScovilleTest().solution(scoville, K));
	}
	public int solution(int[] scoville, int K) {
		int count = 0;
		while(!isHigher(scoville, K)) {
			if(scoville.length < 2 && scoville[0] < K) return -1;
			count++;
			int mixedFood = scoville[0] + (scoville[1] * 2);
			int[] tmp = new int[scoville.length - 1];
			tmp[0] = mixedFood;
			for(int i = 1; i < tmp.length; i++) {
				tmp[i] = scoville[i + 1];
			}
			scoville = tmp;
			Arrays.sort(scoville);
		}
		return count;
	}
	public boolean isHigher(int[] scoville, int K) {
		for(int i = 0; i < scoville.length; i++) {
			if(scoville[i] < K) return false;
		}
		return true;
	}
}
