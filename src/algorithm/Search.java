package algorithm;
/*
 	Binary Search는 정렬된 배열에만 적용가능하다.
 	숫자 맞추기 놀이와 원리가 같다.
 	절반씩 범위를 줄이므로 log2의 n이 시간 복잡도이다.
 */
public class Search {
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 6, 7, 8, 9, 11, 13, 15, 16, 19, 21, 23};
		Search search = new Search();
		System.out.println(search.binarySearch(arr, 11));
	}
	public int binarySearch(int[] arr, int x) {
		return location(arr, 0, arr.length, x);
	}
	private int location(int[] arr, int low, int high, int x) {
		if(low > high) return -1;
		else {
			int mid = (low + high) / 2;
			if(x == arr[mid]){
				return mid;
			}else if(x < arr[mid]) {
				return location(arr, low, mid - 1, x);
			}else {
				return location(arr, mid+1, high, x);
			}
		}
	}
}
