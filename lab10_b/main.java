import code.*;
import java.util.*;


public class main
{
public static void main(String[] args) {
	demo1();
}

public static void demo1() {
	int [] data = {2,1,3,4,5,6,7,8,9};
	BST bst = new BST();
	for (int j = 0; j < data.length; j++)
	bst.insert(data[j]);
	bst.printInOrder();
	System.out.println("Tree height = " + bst.height());
	int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
	bst = new BST();
	for (int j = 0; j < dat.length; j++)
	bst.insert(dat[j]);
	bst.printInOrder();
	System.out.println("Tree height = " + bst.height());
	System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));


}

	
}