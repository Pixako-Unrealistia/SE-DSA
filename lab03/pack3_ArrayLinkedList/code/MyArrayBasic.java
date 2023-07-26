package code;

import java.util.Arrays;

public class MyArrayBasic
{
	protected int MAX_SIZE = 5;
	protected int data[] = new int[MAX_SIZE];
	protected int size = 0;


	public void add(int d)
	{
		if (size < MAX_SIZE)
		{
			data[size] = d;
			size++;
		}
		else
		{
			System.out.println("Overflow");
		}
	}

	public void insert(int d, int index)
	{
		data[index] = d;
		size++;
	}

	public int find(int d)
	{
		for (int i = 0; i< size; i++)
		{
			if (data[i] == d)
			{
				return i;
			}
		}
		return -1;
	}

	public int binarySearch(int d)
	{
		int low = 0;
		int high = size - 1;
		int index = -1;

		while (low <= high) {
			int mid = low  + ((high - low) / 2);
			if (data[mid] < d) {
				low = mid + 1;
			} else if (data[mid] > d) {
				high = mid - 1;
			} else if (data[mid] == d) {
				index = mid;
				break;
			}
		}
		return index;
	}

	public void delete(int index)
	{
		for (int i = index; i < size - 1; i++)
		{
			data[i] = data[i + 1];
		}
		size--;
		if (size < 0)
		{
			size = 0;
		}
	}

	public MyArrayBasic(int ... a)
	{
		if (a == null)
		{
			return;
		}
		if (a.length > MAX_SIZE)
		{
			MAX_SIZE = a.length;
			data = new int[MAX_SIZE];
			return;
		}
		size = a.length;
		for (int i = 0; i < MAX_SIZE; i++)
		{
			data[i] = a[i];
		}
	}

	public MyArrayBasic()
	{
	}

	@Override
	public String toString() {
		return "MyArrayBasic [data=" + Arrays.toString(data) + "]";
	}

}