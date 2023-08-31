/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {
	
	//notes
	// throw new IndexOutOFBouncdsException();
    
    /* Internal Object counter */
    protected int objectCount;
    
    /* Internal Object array */
    protected E [] internalArray;
    
    /* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
    public MyArrayList() {
        this.internalArray = (E[])new Object[100];
    }
    
    /* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity){
        this.internalArray = (E[])new Object[initialCapacity];
    }
    
    /* Return the number of active slots in the array list */
    public int size() {
        /* ---- YOUR CODE HERE ---- */
    	return objectCount;
    }
    
    /* Are there zero objects in the array list? */
    public boolean isEmpty() {
        /* ---- YOUR CODE HERE ---- */
    	return size() == 0;
    }
    
    /* Get the index-th object in the list. */
    public E get(int index) {
        /* ---- YOUR CODE HERE ---- */
    	//edge case- index doesn't exist
    	checkIndex(index);
    	return internalArray[index];
    }
    
    /* Replace the object at index with obj.  returns object that was replaced. */
    public E set(int index, E obj) {
        /* ---- YOUR CODE HERE ---- */
    	E temp;
    	//edge case-index doesnt exist, -u cant put the object in there
    	//possible edgecase-obj doesnt exist?
    	checkIndex(index);
    	temp = internalArray[index];
    	internalArray[index] = obj;
    	return temp;
    	
    }

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
    public boolean contains(E obj) {
    	/* ---- YOUR CODE HERE ---- */
    	for (int i = 0; i < objectCount;i++)
    	{
    		if (internalArray[i] == obj || internalArray[i] != null && internalArray[i].equals(obj))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    //note to self-check if u even need this index out of boudns for every single method
    public void checkIndex(int index)
    {
    	if (index > objectCount -1 || index < 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    }
    /* Insert an object at index */
	@SuppressWarnings("unchecked")
	//add at an index at the end is wrong
    public void add(int index, E obj) {
        /* ---- YOUR CODE HERE ---- */
		if (index > objectCount || index < 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
		if (objectCount == internalArray.length)
		{
			resize();
		}
			E[] temp = (E[])new Object[internalArray.length];
			for (int i = 0; i < index;i++)
			{
				temp[i] = internalArray[i];
			}
			temp[index] = obj;
			for (int i = index + 1; i < temp.length;i++)
			{
				temp[i] = internalArray[i - 1];
			}
			internalArray = temp;
			objectCount++;
	 
    }
	@SuppressWarnings("unchecked")
	public void resize()
	{

		  E[] temp = (E[])new Object[internalArray.length*2];
		  for (int i = 0; i < internalArray.length; i++)
		  {
			 temp[i] = internalArray[i];
		  }
		  internalArray = temp;
	}
    /* Add an object to the end of the list; returns true */
	public boolean add(E obj) {
        /* ---- YOUR CODE HERE ---- */
		
		if (objectCount == internalArray.length)
		{
			resize();
		}
		internalArray[objectCount] = obj;
		objectCount++;
		
		//System.out.println("obCount: " + objectCount);
		//System.out.println("internRayLen: " + internalArray.length);
		return true;
    }

    /* Remove the object at index and shift.  Returns removed object. */
	@SuppressWarnings("unchecked")
    public E remove(int index) {
        /* ---- YOUR CODE HERE ---- */
    	checkIndex(index);
    	E obj = internalArray[index];
    	for (int i = index + 1; i < objectCount; i++)
        	{
        		internalArray[i -1] = internalArray[i];
        	}
    	System.out.println(objectCount);
    	objectCount--;
    	return obj;
    }
    
    /* Removes the first occurrence of the specified element from this list, 
     * if it is present. If the list does not contain the element, it is unchanged. 
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
     * Returns true if this list contained the specified element (or equivalently, 
     * if this list changed as a result of the call). */
    public boolean remove(E obj) {
        /* ---- YOUR CODE HERE ---- */
    	for(int i = 0; i < objectCount; i++)
    	{
    		if (internalArray[i] == obj || internalArray[i] != null && internalArray[i].equals(obj))
    		{
    			remove(i);
    			
    			return true;
    		}
    	}
    	return false;
    }
    
	// This method will search list for all occurrences of obj and move them to the end
	// of the list without disrupting the order of the other elements.
	public void moveToBack3(E obj)
	{
		for (int i = objectCount - 1; i>=0; i --)
		{
			if (internalArray[i] == null && obj == null && internalArray[i] == obj)
			{
				add(remove(i));
			}
			else if(internalArray[i] != null && internalArray[i].equals(obj))
			{
				add(remove(i));
			}
		}
		
	}
	public void moveToBack2(E obj)
	{
		int toRemoveAmount = 0;
		for(int i = 0; i < objectCount; i++)
    	{
    		if (internalArray[i] == obj)
    		{
    			
    			toRemoveAmount++;
    		}
    	}
		for(int i = 0; i < toRemoveAmount; i++)
		{
			remove(obj);
			add(obj);
			
		}
	}
	public void moveToBack(E obj)
	{
	
		int tempIndex = 0;
		E[] temp = (E[])new Object[internalArray.length];
		for(int i = 0; i < objectCount; i++)
    	{
    		if (!internalArray[i].equals(obj) || internalArray[i] == null && obj == null && internalArray[i] == obj)
    		{
    			temp[tempIndex] = internalArray[i];
    			tempIndex++;
    		}

  
    	}
		for (int i = tempIndex; i < internalArray.length;i++)
		{
			temp[i] = obj;
			
		}
		internalArray = temp;
	}
	public void clear()
	{
		E[] temp = (E[]) new Object[size()];
		internalArray = temp;
		objectCount = 0;
	}
	public void clear1()
	{
	    for (int i = objectCount - 1;i > -1; i--)
	    {
	    	remove(i);
	    }
	    //objectCount=0;
	}
    public void clear2()
    {
    	int curObjCount = objectCount;

    	for (int i = 0;i < curObjCount;i++)
    	{
    		
    		remove(0);
    	}
    	
  
    }
    public int lastIndexOf(E obj)
    {
    	
    	for (int i = objectCount;i < 0;i --)
    	{
    		if (internalArray[i] == obj || internalArray[i] != null && internalArray[i].equals(obj))
    		{
    			return i;
    		}
    	}
    	return -1;
    }
    public void trimToSize()
    {
    	E[] temp = (E[]) new Object[size()];
    	for(int i = 0;i< objectCount;i++)
    	{
    		temp[i] = internalArray[i];
    	}
    	internalArray = temp;
    }
    public MyArrayList<E> clone()
    {
    	MyArrayList<E> cloneList = new MyArrayList<E>(size());
    	
    	cloneList.internalArray = this.internalArray;
    	cloneList.objectCount = objectCount;
    	return cloneList;
    	
    }
    /* For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the elements in the ArrayList.
     * If the array is empty, it should return "[]".  If there is one element, "[X]", etc.
     * Elements are separated by a comma and a space. */
    
    public String toString() {
//        /* ---- YOUR CODE HERE ---- */
////    	if (isEmpty())
////    	{
////    		return "[]";
////    	}
////    	else {
////    	String returnedString = "[";
//    	for (int i = 0;i< objectCount - 1; i++)
////    	{
//    		returnedString += internalArray[i] + ", ";
//    	}
//    	returnedString += internalArray[objectCount - 1];
//    	returnedString += "]";
//    	return returnedString;
//    	}
//    	
//    	
//    	
//    }
    	  StringBuilder sb = new StringBuilder();
    	    if(internalArray == null) {
    	        return "[]";
    	    } else {

    	    for (int i = 0; i < objectCount; i++) {
    	        sb.append(internalArray[i]);
    	        if(i != objectCount - 1) {
    	        	sb.append(", ");
    	        }
    	    }

    	    return "[" + sb.toString() + "]";
    	    }
    }
    public static void main(String[] args)
    {
    	MyArrayList list = new MyArrayList();
    	list.add(null);
    	list.add("monkey");
    	list.add(2,"end");
    	System.out.println(list + "" + list.size());
    }

}