import code.MyArrayBasic;
import code.MyArray;

public class L3_ArrayTester_Main {
  public static void main(String[] args) {
    System.out.println("-demo1-------");
    arrayBasic_demo1();
    System.out.println("-demo2-------");
    arrayBasic_demo2();
    System.out.println("-demo3-------");
    arrayBasic_demo3();
	System.out.println("-demo4-----");
	myArray_demo4();
	System.out.println("-task2-----");
	task2();

  }

  static private void arrayBasic_demo1() {
    MyArrayBasic demo =
      new MyArrayBasic(7, 6, 8, 1, 2, 3);
	  System.out.println(demo);
  }
  static private void arrayBasic_demo2() {
    MyArrayBasic demo = new MyArrayBasic();
    demo.insert(9, 0);
    demo.insert(7, 0);
    demo.insert(5, 0);
    System.out.println(demo);
    System.out.println("5 is at " + demo.find(5));
    System.out.println("5 is at " + demo.binarySearch(5));
    demo.delete(1);
    System.out.println(demo);
  }
  static private void arrayBasic_demo3() {
    MyArrayBasic demo = new MyArrayBasic(null);
    demo.add(3);
    demo.add(7);
    demo.add(5);
    demo.add(4);
    demo.add(6);
    //index out of bound due to overflow
    demo.add(1);
  }
  static private void myArray_demo4() {
	MyArray demo = new MyArray(5);
	demo.delete(0);
	demo.add(3);
	demo.add(7);
	demo.add(5);
	demo.add(4);
	demo.add(6);
	demo.add(1);
	System.out.println(demo);
	}

	static private void task2() {
		for (int N = 200_000; N <= 10 * 200_000; N += 200_000) {
			long start = System.currentTimeMillis();
			MyArray mArray = new MyArray(N);
			for (int n = 1; n <N; n++)
				mArray.add((int)(Math.random()*1000));
			long time = (System.currentTimeMillis() - start);
			System.out.println(N + "\t\t" + time);

		}
		System.out.println("with expansion");
		for (int N = 200_000; N <= 10 * 200_000; N += 200_000) {
			long start = System.currentTimeMillis();
			MyArray mArray = new MyArray();
			for (int n = 1; n <N; n++)
				mArray.add((int)(Math.random()*1000));
			long time = (System.currentTimeMillis() - start);
			System.out.println(N + "\t\t" + time);
		}
		}

}