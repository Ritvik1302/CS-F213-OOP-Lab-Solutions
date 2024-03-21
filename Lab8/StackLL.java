import java.util.*;

public class StackLL {

	private LinkedList<Object> ll = new LinkedList<Object>();

	public Object pop() {
		return ll.remove();
	}

	public void push(Object i1) {
		ll.addFirst(i1);
		return;
	}

	public Object top() {
		return ll.getFirst();
	}

	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public boolean search(Object o1) {
		return ll.contains(o1);
	}

	public static void main(String[] args) {
		StackLL s1 = new StackLL();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		System.out.println(s1.top());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	}
}
