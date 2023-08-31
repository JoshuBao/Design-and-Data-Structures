import java.util.*;

public class Stack<E> {

	ArrayList<E> list;

	public Stack() {
		list = new ArrayList<E>();
	}

	public E pop() {
		return list.remove(list.size() - 1);
	}

	public void push(E object) {
		list.add(object);
	}

	public E peek() {
		return list.get(list.size() - 1);
	}

	public boolean isEmpty() {
		if (list.size() == 0) {
			return true;
		}
		return false;

	}
}