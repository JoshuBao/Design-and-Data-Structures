// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {

	private BinaryNode<E> root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}

	boolean monkey = false;

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		BinaryNode<E> curr = root;
		while (curr != null) {
			int comparison = value.compareTo(curr.getValue());
			if (comparison == 0) {
				return true;
			} else if (comparison < 0) {
				curr = curr.getLeft();
			} else {
				curr = curr.getRight();
			}
		}
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		if (root == null) {
			root = new BinaryNode<>(value);
			return true;
		}
		BinaryNode<E> parent = null;
		BinaryNode<E> curr = root;
		while (curr != null) {
			int comparison = value.compareTo(curr.getValue());
			if (comparison == 0) {
				return false;
			} else if (comparison < 0) {
				parent = curr;
				curr = curr.getLeft();
			} else {
				parent = curr;
				curr = curr.getRight();
			}
		}
		if (value.compareTo(parent.getValue()) < 0) {
			parent.setLeft(new BinaryNode<>(value));
		} else {
			parent.setRight(new BinaryNode<>(value));
		}
		return true;
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(E value) {
		if (contains(value)) {
			BinaryNode<E> removeNode = returnNode(value);
			BinaryNode<E> parent = getParent(removeNode);
			
			if (!root.hasChildren())
			{
				root = null;
				return true;
			}
			if (root.getValue().compareTo(value) == 0)
			{
				rootRemove(value);
				return true;
			}
			
			if (removeNode.hasLeft() && removeNode.hasRight())
			{
				E max  = (E) largestOftheLeft(removeNode).getValue();
				remove(max);
				removeNode.setValue(max);
				return true;
			}
			if (removeNode.hasLeft())
			{
				if (leftRight(parent,removeNode))
				{
				parent.setRight(removeNode.getLeft());
				return true;
				}
				parent.setLeft(removeNode.getLeft());
				return true;
			}
			if (removeNode.hasRight())
			{
				if (leftRight(parent,removeNode))
				{
				parent.setRight(removeNode.getRight());
				return true;
				}
				parent.setLeft(removeNode.getRight());
			}
			else {
				 if (leftRight(parent,removeNode))
				 {
					 parent.setRight(null);
					 return true;
				 }
				 else
				 {
					 parent.setLeft(null);
					 return true;
				 }
			}
			
			//System.out.println("removeNode" + removeNode.getValue() + parent + "lofL" + largestOftheLeft(removeNode));
		}
		return false;
	}
	public boolean rootRemove(E value)
	{
		BinaryNode<E> removeNode = root;
		
		if (removeNode.hasLeft() && removeNode.hasRight())
		{
			E max  = (E) largestOftheLeft(removeNode).getValue();
			remove(max);
			root.setValue(max);
			return true;
		}
		if (removeNode.hasLeft())
		{
			root = root.getLeft();
			return true;
		}
		if (removeNode.hasRight())
		{
			root = root.getRight();
			return true;
		}
		else {
			root.setValue(null);
		}
		
		
		return false;
	}
	public boolean leftRight(BinaryNode<E> parent, BinaryNode<E> child)
	{
		//true if right, false if left
		if (parent.getValue().compareTo(child.getValue()) > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public BinaryNode<E> returnNode(E value)
	{
		BinaryNode<E> curr = root;
		while (curr != null) {
			int comparison = value.compareTo(curr.getValue());
			if (comparison == 0) {
				return curr;
			} else if (comparison < 0) {
				curr = curr.getLeft();
			} else {
				curr = curr.getRight();
			}
		}
		return null;
	}
	
	
	public BinaryNode<E> getParent(BinaryNode<E> Child)
	{
		BinaryNode<E> curr = root;
		BinaryNode<E> oneBehind = root;

		while (curr != null) {
			int comparison = Child.getValue().compareTo(curr.getValue());
			if (comparison == 0) {
				return oneBehind;
			} else if (comparison < 0) {
				oneBehind = curr;
				curr = curr.getLeft();
				
			} else {
				oneBehind = curr;
				curr = curr.getRight();
			
			}
		}
		return oneBehind;
	}
	public BinaryNode<E> largestOftheLeft(BinaryNode<E> nodeRemoving)
	{
		BinaryNode<E> curr = nodeRemoving.getLeft();
		while (curr.hasRight())
		{
			curr = curr.getRight();
		}
		return curr;
	}
	
	
	// Returns a bracket-surrounded, comma separated list of the contents of the
	// nodes, in order
	// e.g. ["Apple", "Cranberry", "Durian", "Mango"]
	//neeed an edge case for only root
	public String toString() {
		
		//neeed an edge case for only root	//neeed an edge case for only root	//neeed an edge case for only root	//neeed an edge case for only root
		StringBuilder sb = new StringBuilder();
		if (root == null)
		{
			return "[]";
		}
		if (root.hasLeft() && root.hasRight())
		{
		sb.append("[" + toString(root.getLeft()) + root.getValue() + ", " + toString(root.getRight()));
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
		}
		if (root.hasLeft())
		{
			sb.append("[" + toString(root.getLeft()) + root.getValue());
			sb.delete(sb.length() - 2, sb.length());
			sb.append("]");
			return sb.toString();
		}
		if (root.hasRight())
		{
			sb.append("[" + root.getValue() + ", " + toString(root.getRight()));
			sb.delete(sb.length() - 2, sb.length());
			sb.append("]");
			return sb.toString();
		}
		else
		{
			sb.append("[" + root.getValue() + "]");
			return sb.toString();
		}
		
		
	}
	public String toString(BinaryNode child)
	{
		if (child.hasLeft() && child.hasRight()) {
			return toString(child.getLeft()) + child.getValue() + ", " + toString(child.getRight());
			
		}
		if (child.hasLeft())
		{
			return toString(child.getLeft()) + child.getValue() + ", ";
		}
		if (child.hasRight())
		{
			return child.getValue() + ", "  + toString(child.getRight());
		}
		else
		{
			return child.getValue() + ", ";
		}
		
	}
	

}
