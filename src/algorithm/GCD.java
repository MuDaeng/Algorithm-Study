package algorithm;
/*
 	최대공약수 찾기 알고리즘
 	빼기로 찾는것은 신기하다.
 	재귀로 코드를 짜니까 코드가 매우 간결해졌다.
 */
public class GCD {
	public static void main(String[] args) {
		System.out.println(new GCD().gcdWithMinus(48, 18));
		System.out.println(new GCD().gcdWithMod(48, 18));
		System.out.println(new GCD().gcdWithRecursive(48, 18));
	}
	public int gcdWithMinus(int a, int b) {
		while(a != 0 && b != 0 && a != b) {
			if(a > b) {
				a = a - b;
			}else {
				b = b - a;
			}
		}
		if(a != 0) return a;
		else return b;
	}
	public int gcdWithMod(int a, int b) {
		while(b != 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
	public int gcdWithRecursive(int a, int b) {
		if(b == 0) return a;
		return gcdWithRecursive(b, a % b);
	}
}
