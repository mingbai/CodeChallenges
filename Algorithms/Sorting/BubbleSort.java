/**BubbleSort**/

/*
_________________________
4 | 5 | 3 | 6 | 2| 7 | 1
_________________________
bubble sort的实质是小数值元素移动到前面。从数组的末尾开始，循环比较当前元素与前一个元素的大小，如果小于前一个元素，两元素进行数值交换。
或者从数组头部开始，循环比较当前元素和后一个元素的大小，小于则交换。。。

每一次循环会确定当前需要排序的所有元素中最大元素的位置，整体循环次数为数组的长度。为每一个元素找到相应位置的循环次数为当前需要排序的元素的个数。

*/
public void bubbleSort(int[] unsorted) {
	int size = unsorted.length;

	for(int i = 0; i < size - 1; i++) {
		for(int j < size - 1; j > i; j--) {
			if(unsorted[j] < unsorted[j - 1]) {
				swap(unsorted, j - 1, j);
			}
		}
	}
}

public void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}