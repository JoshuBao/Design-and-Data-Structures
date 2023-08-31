import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;

// Implements a singly-linked list.


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
		for (int i = 0; i < values.length;i++)
		{
			add((E) values[i]);
		}
		
		
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	
	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return head == null;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		ListNode<E> currNode = head;
		for (int i = 0;i < nodeCount;i++)
		{
			if (currNode.getValue() == obj)
			{
				return true;
			}
			currNode = currNode.getNext();
		
		}
		return false;
	}
	
	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		ListNode<E> currNode = head;
		int i = 0;
		for (currNode = head; currNode != null;currNode = currNode.getNext())
		{
		
			if (obj == null && currNode.getValue() == obj)
			{
				return i;
			}
			else if (currNode.getValue() == obj)
			{
				return i;
			}

			i++;
		
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		if (nodeCount == 0)
		{
			ListNode<E> newNode = new ListNode<E>(obj);
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(new ListNode<E>(obj));
			tail = tail.getNext();
			
		}
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (contains(obj) == false)
		{
			return false;
			
		}
		int special = indexOf(obj);
		remove(special);
		
		return true;
//		int indexOf
//		ListNode<E> currNode = head;
//		for (currNode = head; currNode != null;currNode = currNode.getNext())
//		{
//			if (currNode.getValue().equals(obj) && head.equals(currNode) )
//			{
//				head = currNode.getNext();
//				//currNode.setNext(null);
//				return true;
//			}
//			else if (currNode.getNext().getValue().equals(obj))
//			{
//				System.out.println("i ran yuh");
//				currNode.setNext(currNode.getNext().getNext());
//				return true;
//			}
////			else if (i == nodeCount -1 && currNode.getNext() == tail && currNode.getNext().getValue() == obj)
////			{
////				System.out.println("i ran yuh 2");
////				currNode.setNext(null);
////				tail = currNode;
////				nodeCount--;
////				return true;
////				
////			}
//			
//		}
		
	
	}

	// Returns the i-th element.               
	public E get(int i) {
		if (i > nodeCount || i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currNode = head;
		for (int j = 0;j < i;j++)
		{
			currNode = currNode.getNext();
		}
		return (E) currNode.getValue();
		//CHECK IF IT MATTERS IF THE HOMIE DOESNT EXIST IN THE INDEX
	}
	public int getNodeCount()
	{
		return nodeCount;
	}
	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		if (i > nodeCount || i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currNode = head;
		for (int j = 0;j < i;j++)
		{
			currNode = currNode.getNext();
		}

		Object tempVal = currNode.getValue();
		currNode.setValue((E) obj);
		return (E) tempVal;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		if (i > nodeCount || i < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currNode = head;
//		if (i == 0)
//		{
//			ListNode<E> newNode = new ListNode<E>(obj);
//			head = newNode;
//			tail = newNode;
//		}
		for (int j = 0;j < i - 1;j++)
		{
			currNode = currNode.getNext();
		}
		ListNode<E> newNode = new ListNode<E>((E) obj);
		ListNode<E> nodeAhead = currNode.getNext();
		newNode.setNext(nodeAhead);
		currNode.setNext(newNode);
		nodeCount++;
		
		
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		
		if ( i == nodeCount || contains(get(i)) == false)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> currNode = head;
		ListNode<E> lagNode = currNode;
		if (i == 0)
		{
			head = currNode.getNext();
		}
		for (int j = 0;j < i ;j++)
		{	
			lagNode = currNode;
			currNode = currNode.getNext();
		}
		Object tempVal = currNode.getValue();
		if (currNode == tail)
		{
			ListNode<E> nodeAhead = currNode.getNext();
//			Object tempVal = currNode.getValue();
			lagNode.setNext(nodeAhead);
			tail = lagNode;
		}
		else
		{
			ListNode<E> nodeAhead = currNode.getNext();
		
			lagNode.setNext(nodeAhead);
		}
	
		//FIX UP TAILS, TAILS AINT NEVA FIXED bruh then double check that head is always s3et correctly
//		if (nodeCount - 1 == i)
//		{
//			
//			tail = lagNode.getNext();
//			System.out.println(currNode);
//		}
		nodeCount--;
		return (E) tempVal;
//		ListNode<E> currNode = head;
//		if (i == 0)
//		{
//			Object temp = currNode.getValue();
//			head = currNode.getNext();
//			nodeCount--;
//			return (E) temp;
//		}
//		else {
//		int k = 0;
//		while(k < i -1)
//		{
//			System.out.println(currNode);
//			currNode = currNode.getNext();
//		}
//		System.out.println("done");
//		Object temp = currNode.getNext().getValue();
//		currNode.setNext(currNode.getNext().getNext());
//		nodeCount--;
//		
//		return (E) temp;
		
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		int k=0;
        for (ListNode current = head; current != null; current = current.getNext())//O(n)
        {
        	sb.append(current.getValue());
        	if (k!=nodeCount-1)
        		sb.append(", ");
        	k++;
        }
        sb.append("]");
        return sb.toString();

	}
	public static void main(String[] args)
	{
		SinglyLinkedList linkster = new SinglyLinkedList();
		linkster.add("wee");
		linkster.add("wee");
		linkster.add("wee");
		linkster.add("wee");
		System.out.println(linkster.getNodeCount());
		System.out.println(linkster);
		
		
		LinkedList list = new LinkedList();
		SinglyLinkedList mylist = new SinglyLinkedList();
//
////		
//		mylist.add("A");
//		mylist.add("B");
//		mylist.add("C");
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		System.out.println(mylist);
//		System.out.println(mylist.get(2));
//		
		//String[] arr = {"A", "B", "C"};
		//mylist = new SinglyLinkedList(arr);
//		mylist.set(1, "Z");
//		list.set(1, "Z");
//		System.out.println(mylist.set(1, "Z"));
//		System.out.println(list.set(1, "Z"));
//		System.out.println(mylist);
//		System.out.println(list);
//		
//		//remove test
//		list = new LinkedList();
//		mylist = new SinglyLinkedList();
//
//		mylist.add("A");
//		mylist.add("B");
//		mylist.add("C");
//		mylist.add("D");
//		mylist.add("E");
//		mylist.add("F");
//		mylist.add("G");
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		list.add("D");
//		list.add("E");
//		list.add("F");
//		list.add("G");
//		
//		
//		System.out.println("dfdf" + mylist);
//		mylist.remove(1);
//		System.out.println("dfdf" + mylist);
////		
		list = new LinkedList();
		mylist = new SinglyLinkedList();
		mylist.add(null);
		mylist.add(null);
		mylist.add("X");
		mylist.add("C");
		mylist.add("D");
		mylist.add("E");
		mylist.add("F");
		mylist.add(0,"scooby");
		System.out.println(mylist.indexOf(null) + "   " + mylist.nodeCount);
		mylist.remove(null);
		mylist.remove("F");
		
		list.add("X");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add(null);
		list.remove(null);
////		
		System.out.println("mylist:" + mylist);
		System.out.println( mylist.getTail().getValue());
		System.out.println("list:" + list);
		
////		mylist.remove("A");
////		list.remove("A");
////		System.out.println("dfdf" + mylist);
////		System.out.println(list);
//
//		System.out.println(mylist.remove("A") + " yuh " + list.remove("A"));
//		
//		System.out.println("dfdf" + mylist);
//		mylist.remove("F");
//		System.out.println("dfdf" + mylist);
//		System.out.println(mylist.remove("G") + "" + list.remove("F"));
//		System.out.println("dfdf" + mylist);
//		
		
		
	}
	

}
