import java.util.ArrayList;

public class MyPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	ArrayList<E> q = new ArrayList<E>();

	public MyPQ() {
		q = new ArrayList<E>();
	}

	public E removeMin() {
		E min = q.get(0);
		for (E num : q) {
			if (num.compareTo(min) < 0) {
				min = num;
			}
		}
		E temp = min;
		q.remove(min);
		return temp;

	}

	public void add(E object) {
		q.add(0, object);
	}

	public E peek() {
		E min = q.get(0);
		for (E num : q) {
			if (num.compareTo(min) < 0) {
				min = num;
			}
		}
		return min;
	}

	public boolean isEmpty() {
		return (q.size() == 0);
	}
}