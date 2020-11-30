***Quick Sort***
*
Quick sort的整体思想是选择一个参照物pivot，将小于等于参照物的元素放置到参照物左侧，大于等于参照物的元素放入右侧。
最坏情况是最小或者最大元素被选择为pivot，通常为了避免此种情况发生，pivot会选择待排序数列的中间元素。
*
public void quickSort(int[] unsorted, int start, int end) {
  if (start >= end) { return; }
  int left = start;
  int right = end;
  int pivot = unsorted[(start + (end - start) / 2)];
  while (left <= right) {
    while (left unsorted[left] < pivot) {
      left++;
    }
    while (unsorted[right] > pivot) {
      right--;
    }
    if (left <= right) {
      int temp = unsorted[left];
      unsorted[left] = unsorted[right];
      unsorted[left] = temp;
      left++;
      right--;
    }
  }
  quickSort(unsorted, start, right);
  quickSort(unsorted, left, end);
}
