/**SelectionSort**/

/*
_________________________
4 | 5 | 3 | 6 | 2| 7 | 1
_________________________

Step 1 − Set MIN to location 0
Step 2 − Search the minimum element in the rest of the array／list
Step 3 − Swap with value at location MIN
Step 4 − Increment MIN to the next element
Step 5 − Repeat until array／list is sorted



*/
public void selectionSort(int[] unsorted) {
	int size = unsorted.length;
	int min = 0;

	for(int i = 0; i < size - 1; i++) {
		min = i;
		for(int j = i + 1; j < size; j++) {
			if(unsorted[j] < unsorted[min]) {
				min = j;
			}
		}
	}
	if(min != i) {
		swap(unsorted, i, min);
	}
}

public void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}