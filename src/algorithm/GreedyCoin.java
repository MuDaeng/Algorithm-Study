package algorithm;

public class GreedyCoin {

	public static void main(String[] args) {
		System.out.println(new GreedyCoin().getCoinNum(23));
	}

	public int getCoinNum(int n) {
		int[] values = new int[30];
		int[] coins = { 1, 4, 5, 6 };
		for (int i = 0; i <= n; i++) {
			values[i] = i;
		}
		for (int i = 1; i < coins.length; i++) {
			for (int j = 0; j <= n; j++) {
				if (coins[i] <= j)
					values[j] = (values[j] < (values[j - coins[i]] + 1)) ? values[j] : values[j - coins[i]] + 1;
			}
		}
		return values[n];
	}
}
