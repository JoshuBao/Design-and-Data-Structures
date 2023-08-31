
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;

	public HeapPQ() {
		this.heap = (E[]) new Comparable[3];
		this.objectCount = 0;
	}

	// Adds obj to the Priority Queue
	public void add(E obj) {
		if (objectCount == heap.length) {
			increaseCapacity();
		}
		heap[objectCount] = obj;
		objectCount++;
		bubbleUp(objectCount - 1);
	}

	// Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin() {
		E value = heap[0];
		swap(0, objectCount - 1);
		heap[objectCount - 1] = null;
		objectCount--;
		bubbleDown(0);
		return value;
	}

	// Returns the MINIMUM element from the Priority Queue without removing it
	public E peek() {
		return heap[0];
	}

	// Returns true if the priority queue is empty
	public boolean isEmpty() {

		return objectCount == 0;
	}

	// Returns the number of elements in the priority queue
	public int size() {
		return objectCount;
	}

	public String toString() {
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++) {
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for (int rowLength = 1, j = 0; j < objectCount; rowLength *= 2) {
			for (int i = 0; i < rowLength && j < objectCount; i++, j++) {
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount) {
				for (int i = 0; i < Math.min(objectCount - j, rowLength * 2); i++) {
					if (i % 2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}

	// Doubles the size of the heap array
	private void increaseCapacity() {
		E[] temp = (E[]) new Comparable[heap.length * 2];
		int i = 0;
		for (E val : heap) {
			temp[i] = val;
			i++;
		}
		heap = temp;
	}

	// Returns the index of the "parent" of index i
	private int parent(int i) {
		if (i == 0) {
			return -1;
		} else if (i < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			if (i % 2 == 0) {
				return i / 2 - 1;
			} else {
				return i / 2;
			}
		}
	}

	// Returns the index of the *smaller child* of index i
	private int smallerChild(int i) {
		int lChild = i * 2 + 1;
		int rChild = i * 2 + 2;
		if (heap[lChild] == null && heap[rChild] == null) {
			return -1;
		} else if (heap[lChild] == null) {
			return rChild;
		} else if (heap[rChild] == null) {
			return lChild;
		}
		if (objectCount > lChild && objectCount >= rChild) {
			if (heap[lChild].compareTo(heap[rChild]) < 0) {
				return lChild;
			} else if (heap[lChild].compareTo(heap[rChild]) > 0) {
				return rChild;
			} else {
				return lChild;
			}
		} else if (objectCount >= lChild && objectCount < rChild) {
			return lChild;
		} else {
			return -1;
		}
	}

	// Swaps the contents of indices i and j
	private void swap(int i, int j) {
		E val = heap[i];
		heap[i] = heap[j];
		heap[j] = val;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i) {
		if (parent(i) >= 0 && heap[parent(i)].compareTo(heap[i]) > 0) {
			swap(i, parent(i));
			bubbleUp(parent(i));

		}
	}

	// find generation method -> finds the generation
	public int findGeneration(int index) {
		if (index == 0) {
			return 0;
		}
		return 1 + findGeneration((index - 1) / 2);
	}

	// Bubbles the element at index i downwards until the heap properties hold
	// again.
	private void bubbleDown(int i) {

		if (smallerChild(i) >= 0 && heap[smallerChild(i)].compareTo(heap[i]) < 0) {
			swap(smallerChild(i), i);
			bubbleDown(smallerChild(i));
		}

	}

}
