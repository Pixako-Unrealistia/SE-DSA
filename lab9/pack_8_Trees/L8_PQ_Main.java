import code.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;




public class L8_PQ_Main {
static ArrayList<Integer> least3;
public static void main(String[] args) {
	System.out.println("-demo1---");
	demo1();
	System.out.println("-demo2---");
	demo2();
}
static void demo1() {
least3 = new ArrayList<>();
MyMinHeap heap = new MyMinHeap();
heap.insert(11); heap.insert(15);
heap.insert(16); heap.insert(13);
heap.insert(17); heap.insert(18);
System.out.println("heap strucutre is " + heap);
least3.add(heap.remove());
least3.add(heap.remove());
least3.add(heap.remove());
System.out.println("least 3 value is " + least3);
}
static void demo2() {
least3 = new ArrayList<>();
MyPriorityQueue pq = new MyPriorityQueue();
pq.enqueue(11); pq.enqueue(15);
pq.enqueue(16); pq.enqueue(13);
pq.enqueue(17); pq.enqueue(18);
pq.enqueue(19); // <-- isFull() is true ... discard
System.out.println("pq structure is " + pq);
least3.add(pq.dequeue());
System.out.println("Performed dequeue: " + pq);
least3.add(pq.dequeue());
System.out.println("Performed dequeue: " + pq);
least3.add(pq.dequeue());
System.out.println("Performed dequeue: " + pq);
System.out.println("least 3 value is " + least3);
}







}