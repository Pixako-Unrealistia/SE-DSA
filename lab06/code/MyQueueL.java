package code;
public class MyQueueL {
	private Node head, tail;
	public MyQueueL() {
	head = tail = null;
}
public void enqueue(String d) 
	{
	Node n = new Node(d);
		if (isEmpty())
			head = tail = n;
		else {
			tail.next = n;
			tail = n;
		}
	}
	public String dequeue() {
	if (isEmpty())
		return "";
	String value = head.value;
	head = head.next;
	if (isEmpty())
		tail = null;
	return value;
	}
	public boolean isEmpty() 
	{
	return head == null;
	}

	public String top() {
	return head.value;
	}
	public String getLast() {
	return tail.value;
	}
	public String dumpToString() {
	StringBuffer sb = new
	StringBuffer();
	Node n = head;
	while (n != null) {
	sb.append(n.value + " ");
	n = n.next;
	}
	return sb.toString();
	}
	@Override
	public String toString() {
	StringBuilder sb = new
	StringBuilder();
	sb.append("First->");
	Node temp = head;
	while (temp != null) {
	sb.append(
	temp.value).append("->");
	temp = temp.next;
	}
	sb.append("Last");
	return sb.toString();
	}
}