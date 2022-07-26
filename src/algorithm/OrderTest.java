package algorithm;

import java.util.Arrays;

public class OrderTest {
	public static void main(String[] args) {
		String[] a = {"AAA",  "BBBB"};
		new OrderTest().solution(a, null);
	}
	public String[] solution(String[] orders, int[] course) {
		String kind;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < orders.length; i++) {
			sb.append(orders[i]);
		}
		char[] tmp = sb.toString().toCharArray();
		Arrays.sort(tmp);
		kind = new String(tmp);
		for(char i = 'A'; i <= 'Z'; i++) {
			String pattern = "[" + String.valueOf(i) + "]+";
			kind = kind.replaceAll(pattern, String.valueOf(i));
		}
		System.out.println(kind);
		return null;
	}
}
