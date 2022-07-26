package algorithm;
/*
 	DP의 원리
 	Optimal Substructure = 전체는 여러개의 작은 문제들로 풀 수 있다.ex 백트래킹
 	Overlapping Subproblem = 하나의 문제는 같은 작은 문제들을 포함한다. 
 */
public class Knapsack {
	private static int[][] ansDP = new int[3][31];
	private static int[] weight = {5, 10, 20};
	private static int[] profit = {50, 60, 140};
	public static void main(String[] args) {
		new Knapsack().getMaxValDP(30);
		for(int[] index : ansDP) {
			for(int item : index) {
				if(item < 100) System.out.print(item + "    ");
				else System.out.print(item + "   ");
			}
			System.out.println();
		}
	}
	public int getMaxValDP(int n) {

		for(int i = 0; i <= n; i++) {
			if(weight[0] <= i) ansDP[0][i] = profit[0];
		}
		for(int i = 1; i < ansDP.length; i++) {
			for(int j = 0; j <= n; j++) {
				if(weight[i] <= j) ansDP[i][j] = (ansDP[i-1][j-weight[i]] + profit[i] > ansDP[i-1][j]) ? ansDP[i-1][j-weight[i]] + profit[i] : ansDP[i-1][j];
				else ansDP[i][j] = ansDP[i-1][j];
			}
		}
		return ansDP[2][n];
	}
}
