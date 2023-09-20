package code;

public class MyStackL {
    private Node top;
    private int size;

    public MyStackL() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        String value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return top.value;
    }

    public int size() {
        return size;
    }
}
