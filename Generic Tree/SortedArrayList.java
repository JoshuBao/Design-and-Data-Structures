import java.util.ArrayList;
import java.util.Collections;

public class SortedArrayList<E extends Comparable<E>> {

	private ArrayList<E> list;
	
	public SortedArrayList(ArrayList<E> list) {
		this.list = list;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean contains(E obj) {
		
		if (Collections.binarySearch(list, obj) > 0)
		{
			return true;
		}
		
//		for (E objFind: list)
//		{
//			if (objFind.equals(obj))
//			{
//				return true;
//			}
//		}
		return false;
	}
	
	//May not contain more than one of the same object
	public boolean add(E obj) {
		if (!contains(obj))
		{
		
			list.add((Collections.binarySearch(list,obj) * -1) - 1,obj);
			return true;
		}
		return false;
	}
	
	public boolean remove(E obj) {
		if (contains(obj))
		{
		list.remove(Collections.binarySearch(list,obj));
		return true;
		}
		return false;
	}
	
	public E min() {
		return list.get(0);
	}
	
	public E max() {
		return list.get(list.size()-1);
	}
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i < list.size(); i++) {
	        sb.append(list.get(i));
	        if (i < list.size() - 1) {
	            sb.append(", ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
	public static void main (String args[])
	{
		ArrayList<Integer> holy = new ArrayList<Integer>(); 
		holy.add(1);
		holy.add(3);
		holy.add(5);
		SortedArrayList bruh = new SortedArrayList(holy);
		bruh.add(6);
		bruh.remove(6);
		System.out.print(bruh);
	}
}
