package code;

public class MyStackA {
    int MAX_SIZE = 100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;

	public boolean isFull() {
        return top == MAX_SIZE;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(double d) {
        if (!isFull()) {
            stack[top] = d;
			top++; //could've put it in the above line, but this is more readable...? According to my last year's professor ;-;
        } else {
            System.out.println("Stack is full. Cannot push " + d);
        }
    }

    public double pop() {
        if (!isEmpty()) {
			top--;
            return stack[top];
        } else {
            System.out.println("Stack is empty. Nothing to pop");
            return Double.NaN; 
        }
    }

    public double top() {
        if (!isEmpty()) {
            return stack[top - 1];
        } else {
            System.out.println("Stack is empty. Nothing on top.");
            return Double.NaN;
        }
    }

	@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("top->");
        for (int i = top - 1; i >= 0; i--) {
            sb.append("[");
            sb.append(stack[i]);
            sb.append("]->");
        }
        sb.append("bottom");
        return new String(sb);
    }

}
