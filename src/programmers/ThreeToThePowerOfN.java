package programmers;
/*
 * 3의 거듭 제곱수는 3을 b번 곱한 수를 의미하며 3^b형태로 표현합니다. 
 * 3^0 = 1이 성립하며, 3^1 = 3, 3^2 = 9, 3^3 = 27, 3^4 = 81...모두 거듭 제곱수입니다.
 * 3의 거듭 제곱수를 임의로 더하여 거듭 제곱수 사이에 들어가는 수를 만들 수 있습니다. 예를 들어,
 * 4 = 1 + 3,
 * 31 = 27 + 3 + 1
 * 입니다.
 * 이때, 같은 거듭 제곱수를 2번 이상 더할 수는 없습니다. 
 * 이러한 규칙으로 만들어낼 수 있는 수와 3의 거듭 제곱수를 합쳐서 순서대로 배치하면 1, 3, 4, 9, 10...이 됩니다.
 * 이렇게 배치된 숫자의 n번째 숫자가 무엇인지 알려주는 함수 solution을 완성해주세요.
 * 제한사항 : n은 1이상 10^10이하의 자연수
 * 입출력 예) solution(4) == 9, solution(11) == 31
 * 프로그래머스 채용형인턴 Summer 코딩테스트 2번 문제
 */
public class ThreeToThePowerOfN {
	private static long[] list;
	public long solution(long n) {
		list = new long[(int)n];
		return recursive((int)(n - 1));
	}
	private long recursive(int n) {
		list[0] = 1;
		list[1] = 3;
		if(n == 0) return list[0];
		else if(n == 1) return list[1];
		else {
			for(int i = 2; i <= n; i++) {
				if(isPowerOfTwo(i + 1)) {
					int num = 1;
					int power = 0;
					while(num < i + 1) {
						num *= 2;
						power++;
					}
					num = 1;
					for(int j = 0; j < power; j++) {
						num *= 3;
					}
					list[i] = num;
				}else {
					int tmp = i;
					do{
						tmp--;
					}while(!isPowerOfTwo(tmp + 1));
					list[i] = list[tmp] + list[i - tmp - 1];
				}
			}
		}
		return list[n];
	}
	private boolean isPowerOfTwo(int n) {
		return ((n & (n - 1)) == 0) ? true : false;
	}
}
