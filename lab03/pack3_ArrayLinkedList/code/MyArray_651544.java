package code;

import java.util.Arrays;

public class MyArray extends MyArrayBasic
{
	protected int MAX_SIZE = 100000;
	protected int data[] = new int[MAX_SIZE];
	protected int size = 0;

	//overwrite previous add method
	public void add(int d)
	{
		if (isFull())
		{
			data = expand();
			return;
		}
		data[size] = d;
		size++;
	}

	public boolean isFull()
	{
		return size == MAX_SIZE;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public int [] expandByK(int k)
	{
		int [] temp = new int[MAX_SIZE * k];
		for (int i = 0; i < size; i++)
		{
			temp[i] = data[i];
		}
		MAX_SIZE *= k;
		return temp;
	}

	public int [] expand()
	{
		int [] temp = new int[MAX_SIZE * 2];
		for (int i = 0; i < size; i++)
		{
			temp[i] = data[i];
		}
		MAX_SIZE *= 2;
		return temp;
	}

	public MyArray(int ... a)
	{
		if (a == null)
		{
			return;
		}
		if (a.length > MAX_SIZE)
		{
			MAX_SIZE = a.length;
			return;
		}
		size = a.length;
		for (int i = 0; i < MAX_SIZE; i++)
		{
			data[i] = a[i];
		}
		
	}

	public MyArray(int max)
	{
		MAX_SIZE = max;
		data = new int[MAX_SIZE];
	}

	@Override
	public String toString() {
		return "MyArray [data=" + Arrays.toString(data) + "]";
	}

	public MyArray()
	{
		
	}

}