package algorithm;
/*
 	반복문을 사용하면 피보나치는 for문 하나만 돌아가기에 시간 복잡도는 n이란걸 알 수 있다.
 	공간 복잡도도 for문내에 새로운 변수 tmp만 할당됐다가 소멸되기에 공간복잡도가 낮다.
 	반면 재귀문을 사용한 피보나치는 코드가 간결해지는게 장점이다.
 	그러나 재귀를 사용함으로서 결과값을 찾기 위해 한번에 n - 1의 함수와 n - 2의 함수를 사용하고,
 	그러므로 인해서 시간복잡도는 2^n으로 늘어난다.
 	공간복잡도 또한 함수를 호출하는 할당이 2^n으로 계속해서 스택에 쌓이게 된다.
 	테스트를 위해 n을 100으로 잡고 시간을 쟀는데 반복문은 0.001초가 나왔고,
 	재귀문은 10분이 지났는데 결과가 나오지 않았다.
 	Dynamic Programming을 사용했을 때, 반복문보다 소요시간이 더 적었다?
 */
public class Fibonacci {
	private static long[] dp = new long[300];
	public static void main(String[] args) {
		Fibonacci fibo = new Fibonacci();
		long iterativeTime = System.nanoTime();
		System.out.println(fibo.fiboIterative(100));
		System.out.println(System.nanoTime() - iterativeTime);
		long dpTime = System.nanoTime();
		System.out.println(fibo.fiboDP(100));
		System.out.println(System.nanoTime() - dpTime);
	}
	public long fiboIterative(int n) {
		long a = 0;
		long b = 1;
		long tmp;
		for(int i = 0; i < n; i++) {
			tmp = a + b;
			a = b;
			b = tmp;
		}
		return a;
	}
	public long fiboRecursive(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else return fiboRecursive(n - 1) + fiboRecursive(n - 2);
	}
	public long fiboDP(int n) {
		if(dp[n] != 0) return dp[n];
		else if(n == 0) return 0;
		else if(n == 1) return 1;
		else {
			dp[n] = fiboDP(n - 1) + fiboDP(n - 2);
		}
		return dp[n];
	}
}
