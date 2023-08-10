import code.MyLinkedList;

public class L4_LinkedList_Main {
    public static void main(String[] args) {
        System.out.println("-demo1--------");
        demo1();
        System.out.println("-demo2--------");
        demo2();
        System.out.println("-q1--------");
        q1();
        System.out.println("-q2--------");
        q2();
        System.out.println("-q3--------");
        q3();
        System.out.println("-q4--------");
        q4();
        System.out.println("-q5--------");
        q5();
    }
    static void demo1() {
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(1);
        list.insert(4);
        list.insert(3);
        System.out.println(list);
        list.delete(2);
        System.out.println("5 is at " + list.find(5));
        System.out.println(list);
    }
    static void demo2() {
        MyLinkedList mList = new MyLinkedList();
        mList.insert(50);
        mList.insert(40);
        mList.insert(30);
        mList.insert(20);
        mList.insert(10);
        System.out.println(mList);
    }
    static void q1() {
        int [] d = {10,20,30,40,50};
        MyLinkedList mList = new MyLinkedList();
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q1_rotate_clockwise(1);
        System.out.println("(k = " + 1 + ")  -> " + mList);
        mList.q1_rotate_clockwise(3);
        System.out.println("(k = " + 3 + ")  -> " +mList);
        mList.q1_rotate_clockwise(7);
        System.out.println("(k = " + 7 + ")  -> " +mList);
    }
    static void q2() {
        int [] d = {1,2,3,4,5,6,7,8};
        MyLinkedList mList = new MyLinkedList();
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q2_reverse();
        System.out.println("after  -> " + mList);
    }
    static void q3() {
        int [] d = {13, 11, 4, 15, 4};
        MyLinkedList mList = new MyLinkedList();
        mList.insert(d);
		mList.add(5);
		mList.add(4);
		mList.add(5);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after  -> " + mList);
        int [] e = {13, 11, 15, 4};
        mList = new MyLinkedList();
        mList.insert(e);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after  -> " + mList);
    }
    static void q4() {
        int [] d = {1, 9, 9, 9};
        MyLinkedList mList = new MyLinkedList();
        //mList.add(d);
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q4_increment_digits();     
        System.out.println("after  -> " + mList);  
         // bonus 
        d[0] = 9;
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q4_increment_digits();     
        System.out.println("after  -> " + mList);      
         
    }
    static void q5() {
        int [] d = {21, 33, 33, 21};
        boolean isPalind;
        MyLinkedList mList = new MyLinkedList();
        mList.add(d);
        isPalind = mList.q5_isPalindrome();     
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] e = {21, 33, 44, 33, 21};
        mList = new MyLinkedList();
        mList.add(e);
        isPalind = mList.q5_isPalindrome();  
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] f = {1, 9, 9, 9};
        mList = new MyLinkedList();
        mList.add(f);
        isPalind = mList.q5_isPalindrome();  
        System.out.println(mList + " isPalindrome() = " + isPalind);
    }
}