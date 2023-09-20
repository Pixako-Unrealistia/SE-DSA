import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L8b_sorter
{
	public static void whatSortIsThis(int [] arr, int PREFERRED_SIZE) {
        int BLOCK_SIZE = arr.length / 4 > PREFERRED_SIZE ? PREFERRED_SIZE : arr.length / 4;
	for (int start = 0; start < arr.length; start += BLOCK_SIZE) {
	int end = Math.min(start + BLOCK_SIZE - 1, arr.length - 1);
	bite_size_sort(arr, start, end);
	}
	for (int mergeSize = BLOCK_SIZE; mergeSize < arr.length; mergeSize *= 2) {
	for (int left = 0; left < arr.length; left += 2 * mergeSize) {
	int mid = left + mergeSize - 1;

	//Code 1
	int right = Math.min(left + 2 * mergeSize - 1, arr.length - 1);	
	//Code 1

	if (mid < right)
	merge(arr,left, mid, right);
	}
	}
	System.out.println(Arrays.toString(arr));
	}
	private static void bite_size_sort(int [] b, int start, int end)
	{
	//Code 2
	for (int i = start + 1; i <= end; i++)
	{
	//Code 2
	
		int j = i;
	int tmp = b[j];
	while (j > start && b[j - 1] > tmp) {
	b[j] = b[j-1];
	j--;
	}
	b[j] = tmp;
	}
	}
	private static void merge(int [] twob, int low, int mid, int high) {
	int [] leftArr = new int[mid - low + 1];
	int [] rightArr = new int[high - mid];
	System.arraycopy(twob, low, leftArr, 0, leftArr.length);
	System.arraycopy(twob, mid + 1, rightArr, 0, rightArr.length);
	int leftCounter = 0;
	int rightCounter = 0;
	int twobCounter = low;
	while (leftCounter < leftArr.length && rightCounter < rightArr.length) {
	//Code 3
	twob[twobCounter++] = leftArr[leftCounter] < rightArr[rightCounter] ? leftArr[leftCounter++] : rightArr[rightCounter++];
	//Code 3
	}
	while (leftCounter < leftArr.length)
	twob[twobCounter++] = leftArr[leftCounter++];
	while (rightCounter < rightArr.length)
	twob[twobCounter++] = rightArr[rightCounter++];
	}


	private static void testRuntime() {
	int ARRAY_SIZE = 2_00_000;
	int [] arr32 = new int[1];
	int [] arr2048 = new int[1];;
	int [] arr3 = new int[1];;
	int numIter = 10;
	int [] size32Time = new int[numIter];
	int [] size2048Time = new int[numIter];
	int [] sizeSortTime = new int[numIter];
	ArrayList<Integer> list = new ArrayList<>();
	for (int i = 1; i <= ARRAY_SIZE; i++)
	list.add(i);
	for (int i = 0; i < numIter; i++) {
	Collections.shuffle(list);
	arr32 = list.stream().mapToInt(Integer::intValue).toArray();
	arr2048 = list.stream().mapToInt(Integer::intValue).toArray();
	arr3 = list.stream().mapToInt(Integer::intValue).toArray();
	long startElapse = System.currentTimeMillis();
	whatSortIsThis(arr32, 32);
	size32Time[i] = (int)(System.currentTimeMillis() - startElapse);
	startElapse = System.currentTimeMillis();
	whatSortIsThis(arr2048, 2048);
	size2048Time[i] = (int)(System.currentTimeMillis() - startElapse);
	startElapse = System.currentTimeMillis();
	Arrays.sort(arr3);
	sizeSortTime[i] = (int)(System.currentTimeMillis() - startElapse);
	}
	System.out.println("confirm isSort " + isSort(arr32)
	+ " " + isSort(arr2048) + " " + isSort(arr3));
	System.out.println("takes " + Arrays.toString(size32Time));
	System.out.println("takes " + Arrays.toString(size2048Time));
	System.out.println("takes " + Arrays.toString(sizeSortTime));
	}
	private static boolean isSort(int [] arr)
	{
		for (int i = 1; i < arr.length; i++)
		if (arr[i - 1] > arr[i])
		return false;
		return true;
	}

	public static void main(String[] args)
	{
		testRuntime();
	}

}
