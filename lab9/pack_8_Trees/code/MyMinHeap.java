package code;

public class MyMinHeap {
	int MAX_SIZE = 100;
	int heap[] = new int[MAX_SIZE];
	int size = 0;
	public void insert(int d) 
	{
		if (isFull()) {
			System.out.println("Heap is full");
			return;
		}
		heap[size] = d;
		size++;
		heap_up();
	}
	public int remove()
	{
		if (isEmpty()) {
			System.out.println("Heap is empty");
			return -1;
		}
		int root = heap[0];
		heap[0] = heap[size-1];
		size--;
		heap_down();
		return root;
	}
	public int peek()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return -1;
		}
		return heap[0];
	}
	public boolean isFull()
	{
		return size == MAX_SIZE;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public String toString()
	{
		String str = "";
		for (int i = 0; i < size; i++) {
			str += heap[i] + " ";
		}
		return str;
	}

	private void heap_up()
	{
		int index = size - 1;
		while (has_milk(index) && parent(index) > heap[index]) {
			swap(get_daddy_index(index), index);
			index = get_daddy_index(index);
		}
	}

	private void heap_down()
	{
		int index = 0;
		while (has_left(index)) {
			int smallerChildIndex = getleftIndex(index);
			if (has_right(index) && right(index) < left(index)) {
				smallerChildIndex = getrightIndex(index);
			}
			if (heap[index] < heap[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}

	private void swap(int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private boolean has_milk(int i)
	{
		return get_daddy_index(i) >= 0;
	}

	private boolean has_left(int i)
	{
		return getleftIndex(i) < size;
	}

	private boolean has_right(int i)
	{
		return getrightIndex(i) < size;
	}

	private int parent(int i)
	{
		return heap[get_daddy_index(i)];
	}

	private int left(int i)
	{
		return heap[getleftIndex(i)];
	}

	private int right(int i)
	{
		return heap[getrightIndex(i)];
	}

	private int get_daddy_index(int i)
	{
		return (i - 1) / 2;
	}

	private int getleftIndex(int i)
	{
		return 2 * i + 1;
	}

	private int getrightIndex(int i)
	{
		return 2 * i + 2;
	}


}