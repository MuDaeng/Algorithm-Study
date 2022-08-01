package stepFirst;

public class PrimeNumberTest {
	public static void main(String[] args) {
		int[] arr = {1,2,7,6,4};
		System.out.println(new PrimeNumberTest().solution(arr));
	}
	public int solution(int[] nums) {
		int count = 0;
		int length = nums.length;
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j < length; j++) {
				for(int k = j + 1; k < length; k++) {
					if(isPrimeNumber(nums[i] + nums[j] + nums[k])) {
						count++;
					}
				}
			}
		}
		return count;
	}
	private boolean isPrimeNumber(int n) {
		for(int i = 2; i < n; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
}
