package algorithm;

public class Sort {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 7, 8, 9, 5, 4, 1, 6 };
		Sort sort = new Sort();
		int[] clone = arr.clone();
		sort.quickSort(clone);
		sort.showArr(clone);
	}

	public void exchangeSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallest]) {
					smallest = j;
				}
			}
			int tmp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = tmp;
		}
	}

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int index = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > index) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = index;
		}
	}

	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int middle = (right + left) / 2;
		mergeSort(arr, left, middle);
		mergeSort(arr, middle + 1, right);
		int[] leftArr = new int[middle + 1 - left];
		int[] rightArr = new int[right - middle];
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[middle + i + 1];
		}
		int leftCount = 0;
		int rightCount = 0;
		int index = left;
		while (leftCount < leftArr.length || rightCount < rightArr.length) {
			if (leftCount >= leftArr.length) {
				arr[index++] = rightArr[rightCount++];
			} else if (rightCount >= rightArr.length) {
				arr[index++] = leftArr[leftCount++];
			} else {
				if (leftArr[leftCount] < rightArr[rightCount]) {
					arr[index++] = leftArr[leftCount++];
				} else {
					arr[index++] = rightArr[rightCount++];
				}
			}
		}
	}

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int pivotPos = left;
		int pivotItem = arr[left];
		int count = pivotPos;
		for (int i = left + 1; i <= right; i++) {
			if (arr[i] < pivotItem) {
				count++;
				int tmp = arr[count];
				arr[count] = arr[i];
				arr[i] = tmp;
			}
		}
		pivotPos = count;
		int tmp = arr[pivotPos];
		arr[pivotPos] = arr[left];
		arr[left] = tmp;
		pivotPos = count;

		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	private void showArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}
