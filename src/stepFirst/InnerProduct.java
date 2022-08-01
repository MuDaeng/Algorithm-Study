package stepFirst;

import java.util.stream.IntStream;

public class InnerProduct {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4};
		int b[] = {-3, -1 , 0 , 2};
		IntStream.rangeClosed(0, a.length).map(i -> a[i] * b[i]).sum();
	}
}
