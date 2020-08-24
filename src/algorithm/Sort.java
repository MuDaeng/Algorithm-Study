package algorithm;

public class Sort {
	public static void main(String[] args) {
		int[] arr1 = { 3, 4, 6, 1, 8, 9, 7, 5, 2};
		int[] arr2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1};
		new Sort().quickSort(arr1);
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");	
		}
	}
	public void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
	public void selectionSort(int[] arr) {
		int smallest = arr[0];
		int location = 0;
		for(int i = 0; i < arr.length; i++) {
			smallest = arr[i];
			location = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(smallest > arr[j]) {
					location = j;
					smallest = arr[j];
				}
			}
			int tmp = arr[i];
			arr[i] = smallest;
			arr[location] = tmp;
		}
	}
	public void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j >= 1; j--) {
				if(arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}
	public void mergeSort(int[] arr) {
		merge(arr, 0, arr.length - 1);
	}
	private void merge(int[] arr, int low, int high) {
		if(low >= high) {
			return;
		}
		int middle = (low + high) / 2; 
		merge(arr, low, middle);
		merge(arr, middle + 1, high);
		int[] leftArr = new int[middle - low + 1];
		int[] rightArr = new int[high - middle];
		for(int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i + low];
		}
		for(int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[i + middle + 1];
		}
		int leftCount = 0, rightCount = 0;
		for(int i = low; i < leftArr.length + rightArr.length + low; i++) {
			if(leftCount >= leftArr.length) {
				arr[i] = rightArr[rightCount++];
			}else if(rightCount >= rightArr.length) {
				arr[i] = leftArr[leftCount++];
			}else if(leftArr[leftCount] > rightArr[rightCount]) {
				arr[i] = rightArr[rightCount++];
			}else {
				arr[i] = leftArr[leftCount++];
			}
		}
	}
	public void quickSort(int[] arr) {
		quick(arr, 0, arr.length - 1);
	}
	private void quick(int[] arr, int left, int right) {
		if(left >= right) return;
		int leftCount = left;
		int pivot = arr[left];
		int tmp = 0;
		for(int i = left + 1; i <= right; i++) {
			if(pivot > arr[i]) {
				tmp = arr[i];
				arr[i] = arr[++leftCount];
				arr[leftCount] = tmp;
			}
		}
		arr[left] = arr[leftCount];
		arr[leftCount] = pivot;
		quick(arr, left, leftCount - 1);
		quick(arr, leftCount + 1, right);
	}
}
