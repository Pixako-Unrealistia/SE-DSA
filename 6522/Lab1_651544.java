import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lab1_651544 {
  public static void main(String[] args) {
    q1();
    q2();
    q3();
    q4();
    q5();
  }
  /* q1() – q5() */


	static void q1() {
		System.out.println("-q1----");
		List < String > listA = new ArrayList < > (Arrays.asList("lilly", "tulip", "daisy"));
		List < String > listB = Arrays.asList("pomeranian", "terrier", "jack", "beagle");
		/* My code 1 */
		
		listA.addAll(listB);

		/*			*/
		System.out.println(listA);
		System.out.println(listB);
	}

	static void q2() {
		System.out.println("-q2----");
		ArrayList < String > listA = new ArrayList < > (
			Arrays.asList("pomeranian", "terrier", "jack", "beagle"));
		List < String > listB = Arrays.asList("lilly", "tulip", "daisy");
		ArrayList < String > q1List = null;
		/* My code 2 */
		
		//allocate q1List with size of ListA and ListB
		q1List = new ArrayList<String>(listA.size() + listB.size());
		q1List.addAll(listA);
		q1List.addAll(listB);
		
		/* 			 */	
		
		System.out.println(listA);
		System.out.println(listB);
	System.out.println(q1List);
	}



	static void q3() {
	System.out.println("-q3----");
	ArrayList < Dog > q3List = new ArrayList < > ();
	q3List.add(new Dog("jack"));
	q3List.add(new Dog("terrier"));
	System.out.println("snapshot 1 " + q3List);
	add(q3List, new Dog("pomeranian"));
	System.out.println("snapshot 2 " + q3List);
	add(q3List, new Dog("jack"));
	System.out.println("snapshot 3 " + q3List);
	add(q3List, new Dog("beagle"));
	System.out.println(q3List);
	}

	private static void add(ArrayList<Dog> list, Dog dog)
	{
	/* My code 3 */
	if (!list.contains(dog))
		list.add(dog);
	/*		    */
	}

	static void q4() {
	System.out.println("-q4----");
	ArrayList < String > listA = new ArrayList < > (Arrays.asList("jack", "pomeranian", "terrier", "jack", "beagle"));
	ArrayList < String > listB = removeDuplicates(listA);
	listA = removeDuplicates(listA);
	System.out.println(listA);
	System.out.println(listB);
	}

	private static ArrayList < String > removeDuplicates(List < String > list) {
	/* My code 4 */

	HashSet<String> set = new HashSet<String>(list);
	ArrayList<String> newList = new ArrayList<String>(set);
	return newList;
	}

	static void q5() {
	System.out.println("-q5----");
	List < String > listA = Arrays.asList("pomeranian", "terrier", "jack", "beagle",
		"pomeranian", "beagle",
		"jack", "beagle");
	HashMap < String, Integer > q5map = new HashMap < > ();
	String key;
	for (int i = 0; i < listA.size(); i++) {
		key = listA.get(i);
		//My code 5
		q5map.put(key, ((q5map.get(key) == null) ? 1 : q5map.get(key) + 1));
	}
	System.out.println(q5map);
	}
}