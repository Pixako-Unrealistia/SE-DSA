package code;
import java.util.HashSet;
import java.util.Set;


class node {
    int data;
    node next;

    node(int d) {
        data = d;
        next = null;
    }
}

public class MyLinkedList {
    private node head;

    // Task 1
    public void add(int d) {
        node newnode = new node(d);
        newnode.next = head;
        head = newnode;
    }


    public void insert(int d) {
        node newnode = new node(d);

        if (head == null || d < head.data) {
            newnode.next = head;
            head = newnode;
        } else {
            node current = head;
            while (current.next != null && current.next.data < d) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }


    public int find(int d) {
        node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == d) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void delete(int d) {
        if (head == null) {
            return;
        }

        if (head.data == d) {
            head = head.next;
            return;
        }

        node current = head;
        while (current.next != null && current.next.data != d) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Task 2
    private int size() {
        int count = 0;
        node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void add(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            add(d[i]);
        }
    }



    public void insert(int[] d) {
        for (int i = 0; i < d.length; i++) {
            insert(d[i]);
        }
    }

    // Task 3
    public void q1_rotate_clockwise(int k) 
	{
		//this one rotates counterclockwise, the subject said 
		//public void q1_rotate_clockwise(int k) -> Rotate the linked list counter-clockwise
		//if you want clockwise, then use below function

		if (head == null) {
			return;
		}
		
		int size = size();
		k = k % size;
		
		if (k == 0) {
			return;
		}
		
		node current = head;
		for (int i = 0; i < k - 1; i++) {
			current = current.next;
		}
		
		node newhead = current.next;
		current.next = null;
		
		current = newhead;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = head;
		head = newhead;
		

	}

	/* This one rotates clockwise
		if (head == null) {
			return;
		}

		int size = size();
		k = k % size;

		if (k == 0) {
			return;
		}

		node current = head;
		for (int i = 0; i < size - k - 1; i++) {
			current = current.next;
		}

		node newhead = current.next;
		current.next = null;

		current = newhead;
		while (current.next != null) {
			current = current.next;
		}

		current.next = head;
		head = newhead;
    }*/

    public void q2_reverse() {
        node prev = null;
        node current = head;
        node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void q3_remove_dup() {
		Set<Integer> set = new HashSet<>();
		node current = head;
		node prev = null;
		while (current != null) {
			if (set.contains(current.data)) {
				prev.next = current.next;
			} else {
				set.add(current.data);
				prev = current;
			}
			current = current.next;
		}

	 
	}

	/* doesn't support unnsorted list ;-;
        node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    } */

    private node reverseList(node node) {
        node prev = null;
        node current = node;
        node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Task 4
    public void q4_increment_digits() {
        head = reverseList(head);
        node current = head;
        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
            current = current.next;
        }

        if (carry != 0) {
            node newnode = new node(carry);
            current.next = newnode;
        }

        head = reverseList(head);
    }

   	// Task 5
	public boolean q5_isPalindrome() {
		node slow = head;
		node fast = head;
	
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
	
		
		node copiedSecondHalf = copyList(slow);
		node reversedSecondHalf = reverseList(copiedSecondHalf);
		node firstHalf = head;
		while (reversedSecondHalf != null) {
			if (firstHalf.data != reversedSecondHalf.data) {
				return false;
			}
			firstHalf = firstHalf.next;
			reversedSecondHalf = reversedSecondHalf.next;
		}
	
		return true;
	}
	
	private node copyList(node head) {
		if (head == null) return null;
	
		node newHead = new node(head.data);
		node current = newHead;
		node originalCurrent = head.next;
	
		while (originalCurrent != null) {
			current.next = new node(originalCurrent.data);
			current = current.next;
			originalCurrent = originalCurrent.next;
		}
	
		return newHead;
	}
	
	



    public void append(int d) {
        insert(d);
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        node current = head;
        while (current != null) {
            sb.append("(").append(current.data).append(")").append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }	
}