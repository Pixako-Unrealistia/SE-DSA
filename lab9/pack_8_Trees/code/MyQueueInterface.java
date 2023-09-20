package code;
public interface MyQueueInterface {
	public void enqueue(int d);
	public int dequeue();
	public int front();
	public boolean isFull();
	public boolean isEmpty();
}