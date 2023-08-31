
public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private ListNode2<Nucleotide> head;
	private ListNode2<Nucleotide> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		
		head = null;
		
		tail = null;
		
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		
		for (int i = 0; i < values.length;i++)
		{
			add(values[i]);
		}
		
		
	}
	
	public ListNode2<Nucleotide> getHead() {
		
		return head;
		
	}
	
	public ListNode2<Nucleotide> getTail() {
		
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
	public boolean contains(Nucleotide obj) {
		ListNode2 currNode = head;
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
	public int indexOf(Nucleotide obj) {
		int i = 0;
		for (ListNode2<Nucleotide> currNode = head; currNode != null;currNode = currNode.getNext())
		{	
		
			if (currNode.getValue() == obj)
			{
				return i;
			}
			i++;
			
		}
		
		
		
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		ListNode2<Nucleotide> newNode = new ListNode2<Nucleotide> (obj);
		if (isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		nodeCount++;
		return true;
	}
	

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		if (!contains(obj))
		{
			throw new IndexOutOfBoundsException();
		}
		remove(indexOf(obj));
		return true;
		
	}
	

	// Returns the i-th element.               
	public Nucleotide get(int i) {
		if (i < 0 || i> nodeCount)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> currNode = head;
		for(int j = 0;j< i;j++)
		{
			currNode = currNode.getNext();
		}
		return currNode.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (i < 0 || i> nodeCount)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> currNode = head;
		for(int j = 0;j< i;j++)
		{
			currNode = currNode.getNext();
		}
		Nucleotide returnHomie = currNode.getValue();
		currNode.setValue(obj);
	
		return returnHomie;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		if (i < 0 || i> nodeCount)
		{
			throw new IndexOutOfBoundsException();
			
		}
		ListNode2<Nucleotide> currNode = head;
		ListNode2<Nucleotide> newNode = new ListNode2<Nucleotide>(obj);
		if (i == 0)
		{
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
			head.setPrevious(null);
			nodeCount++;
		}
		else if(i == nodeCount)
		{
			add(obj);
		}
		else
		{
			for(int j = 0;j< i;j++)
			{
				currNode = currNode.getNext();
			}
			currNode.getPrevious().setNext(newNode);
			newNode.setPrevious(currNode.getPrevious());
			currNode.setPrevious(newNode);
			newNode.setNext(currNode);
			nodeCount++;
		}

		
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (i < 0 || i> nodeCount)
		{
			throw new IndexOutOfBoundsException();
			
		}
		ListNode2<Nucleotide> currNode = head;
		Nucleotide returnObj = null;
		if (i == 0)
		{
//			if (nodeCount == 1)
//			{
//				head = null;
//				tail = null;
//				nodeCount = 0;
//			}
//			else
//			{
			returnObj = currNode.getValue();
			head = currNode.getNext();
			head.setPrevious(null);
			nodeCount--;
			//}
			
		
		}
		else if(i == nodeCount - 1)
		{
			returnObj = tail.getValue();
			tail = tail.getPrevious();
			tail.setNext(null);
			nodeCount--;
		}
		else 
		{
			for(int j = 0;j< i;j++)
			{
			currNode = currNode.getNext();
			}
			returnObj = currNode.getValue();
			currNode.getPrevious().setNext(currNode.getNext());
			currNode.getNext().setPrevious(currNode.getPrevious());
			nodeCount--;
			
		
		}
	
		return returnObj;
	}
	

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		
		StringBuilder sb = new StringBuilder("[");
		int k=0;
        for (ListNode2 current = head; current != null; current = current.getNext())//O(n)
        {
        	sb.append(current.getValue());
        	if (k!=nodeCount-1)
        		sb.append(", ");
        	k++;
        }
        sb.append("]");
        return sb.toString();

	}
	public String toStringReverse() {
		
		StringBuilder sb = new StringBuilder("[");
		int k=0;
        for (ListNode2 current = tail; current != null; current = current.getPrevious())//O(n)
        {
        	sb.append(current.getValue());
        	if (k!=nodeCount-1)
        		sb.append(", ");
        	k++;
        }
        sb.append("]");
        return sb.toString();
	}
	public void print()
	{
		System.out.println(toString());
		System.out.println(toStringReverse());
	
	}
	
	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	 public void addSegmentToEnd(DoublyLinkedList seg) {
		tail.setNext(seg.getHead());
		seg.getHead().setPrevious(tail);
		tail = seg.getTail();
		nodeCount += seg.size();
     }
	
	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		for (int i =0;i<16;i++)
		{
			remove(indexAfterNodeBefore(nodeBefore));
		}
		
	}
	public int indexAfterNodeBefore(ListNode2<Nucleotide> nodeBefore)
	{
		ListNode2<Nucleotide> currNode;
		int i = 0;
		for(currNode = head; currNode != nodeBefore.getNext(); currNode = currNode.getNext())
		{
			i++;
		}
		return i;
	}
	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	 public boolean deleteSegment(DoublyLinkedList seg) {
	 	ListNode2<Nucleotide> segHead = seg.getHead();
	 	for(ListNode2<Nucleotide> curr = head; curr!= null; curr = curr.getNext())
	 	{
	 		 if (curr.getValue()==segHead.getValue()) 
	 		 {
	 		 	ListNode2<Nucleotide> tempSeg = segHead.getNext();
	 		 	ListNode2<Nucleotide> tempCurr = curr.getNext();
	 		 	boolean stillTrue = true;
	 		 	if (!(tempSeg.getValue()==tempCurr.getValue())) 
	 		 	{
	 		 		stillTrue = false;
	 		 	}
	 		 	while (stillTrue&&(tempSeg.getValue()==tempCurr.getValue()))
	 		 	{
	 		 		if (tempSeg.getNext()==null) break;
	 		 		tempSeg=tempSeg.getNext();
	 		 		tempCurr=tempCurr.getNext();
	 		 		if (!(tempSeg.getValue()==tempCurr.getValue())) stillTrue = false;
	 		 	}
	 		 	if (stillTrue) {
	 		 		//delete the segment starting from curr to the tempCurr 
	 		 		//return true
	 		 		if (tempCurr == tail)
	 		 		{
	 		 			System.out.println("if tail");
	 		 			tail = curr.getPrevious();
	 		 			tail.setNext(null);
	 		 			nodeCount -= seg.size();
	 		 		}
	 		 		else if(curr == head)
	 		 		{
	 		 			System.out.println("if head");
	 		 			head = tempCurr.getNext();
	 		 			head.setPrevious(null);
	 		 			nodeCount -= seg.size();
	 		 		}
	 		 		else 
	 		 		{	
	 		 			System.out.println("if else");
	 		 			removeThisManyAtHere(curr.getPrevious(),seg.size());
	 		 			
	 		 		}
	 		 		
	 		 	}

	 		 }
	 		 
	 	}
         
	 	return false;
     }
	 public void removeThisManyAtHere(ListNode2<Nucleotide> nodeBefore,int size) {
			for (int i =0;i<size;i++)
			{
				remove(indexAfterNodeBefore(nodeBefore));
			}
			
		}
	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		if (nodeCount < 3)
		{
			return false;
		}
		else if (nodeCount == 3)
		{
			head = null;
			tail = null;
			nodeCount = 0;
		}
		else
		{
			for (int i = 0; i< 3;i++)
			{
	
				remove(nodeCount - 1);
			
			}
		}
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {

		ListNode2<Nucleotide> currNode = head;
		DoublyLinkedList listy = new DoublyLinkedList();
		listy.add(Nucleotide.T);
		listy.add(Nucleotide.A);
		listy.add(Nucleotide.C);
//		if (head.getValue() == Nucleotide.A)
//		{
//			add(0,Nucleotide.T);
//			add(2,Nucleotide.C);
//			currNode = currNode.getNext();
//		}
		
		while (currNode != null)
		{
			System.out.println("Current list: (currrent node value = " + currNode.getValue());
			listy.print();
			if (currNode == head && currNode.getValue().equals(Nucleotide.A) && currNode == tail)
			{
				System.out.println("if head and tail ");
				add(0,Nucleotide.T);
				
				add(Nucleotide.C);
				
	
			}
			else if (currNode == head && currNode.getValue().equals(Nucleotide.A))
			{
				System.out.println("if head");
				add(0,Nucleotide.T);
				
				add(2,Nucleotide.C);
			}
			else if (currNode.getValue().equals(Nucleotide.A) && currNode == tail)
			{
				System.out.println("if tail");
				ListNode2<Nucleotide> tSet = new ListNode2<Nucleotide>(Nucleotide.T);
	
				currNode.getPrevious().setNext(tSet);
				tSet.setPrevious(currNode.getPrevious());
				
				tSet.setNext(currNode);
				currNode.setPrevious(tSet);
				
				nodeCount++;
				
				add(Nucleotide.C);
			}
			else if (currNode.getValue().equals(Nucleotide.A))
			{
				System.out.println("if else");
				ListNode2<Nucleotide> tSet = new ListNode2<Nucleotide>(Nucleotide.T);
				currNode.getPrevious().setNext(tSet);
				tSet.setPrevious(currNode.getPrevious());
				tSet.setNext(currNode);
				currNode.setPrevious(tSet);
				nodeCount++;
				
				ListNode2<Nucleotide> cSet = new ListNode2<Nucleotide>(Nucleotide.C);
				currNode.getNext().setPrevious(cSet);
				cSet.setNext(currNode.getNext());
				currNode.setNext(cSet);
				cSet.setPrevious(currNode);
				nodeCount++;
				
			}
		
			System.out.println("current node value: " + currNode.getValue());
			currNode = currNode.getNext();
			
		}
//		int count = 0;
//		for(currNode = head; currNode != null; currNode = currNode.getNext())
//		{
//		
//			if (currNode.getValue() == Nucleotide.A)
//			{
//				add(count, Nucleotide.T);
//				add(count+ 1, Nucleotide.C);
//				
//				//currNode = currNode.getNext();
//				//count++;		
//			}
//			
//			count++;
//			
//		}
		
		
		
		
	}
	
	public static void main(String[] args)
	{
		DoublyLinkedList listy = new DoublyLinkedList();
		DoublyLinkedList listy2 = new DoublyLinkedList();

		listy.add(Nucleotide.C);
		listy.add(Nucleotide.C);	
		listy.add(Nucleotide.G);
		listy.add(Nucleotide.T);
		
		
		
		listy2.add(Nucleotide.C);
		listy2.add(Nucleotide.C);
		listy2.add(Nucleotide.G);
	
		listy.print();
		listy2.print();
		listy.deleteSegment(listy2);
		listy.print();
//		
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
		
		
		//testREMOVENExt16
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.print();
//		listy.removeCCCCCCCCGGGGGGGG(listy.getHead().getNext());
//		listy.print();
//	
//		
		//addSegToEndTest
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		
//		listy2.add(Nucleotide.A);
//		listy2.add(Nucleotide.G);
//		listy2.add(Nucleotide.C);
//		listy2.add(Nucleotide.C);
//		listy2.add(Nucleotide.C);
//		
//		listy.addSegmentToEnd(listy2);
//		listy.print();
		
		//testing deleteLastThree
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.T);
//		listy.add(Nucleotide.T);
//
//
//		listy.deleteLastThree();
//
//		listy.print();
		
		
		
		//test get and set work

//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		listy.set(0, Nucleotide.C);
//		listy.print();
//		System.out.println(listy.get(0));
		
		
		
		//test indexOf
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
//		listy.add(Nucleotide.T);
//		System.out.println(listy.indexOf(Nucleotide.A));

		//testing add, add@i, remove@i
		//DoublyLinkedList listy = new DoublyLinkedList();
//		listy.add(Nucleotide.A);
//		listy.add(Nucleotide.G);
////		listy.add(Nucleotide.C);
////		listy.add(Nucleotide.A);
//		listy.add(1,Nucleotide.T);
//		listy.add(2,Nucleotide.T);
//		listy.add(4,Nucleotide.T);
//		listy.print();
//		listy.add(1,Nucleotide.T);
//		listy.add(4,Nucleotide.G);
//		listy.print();
//		
//		System.out.println(listy.remove(0));
//		System.out.println(listy.remove(4));
//		listy.print();
//		
//		System.out.println(listy.remove(1));
//
//		listy.print();
		
		
	
	}

}
