import java.util.ArrayList;
import java.util.ArrayDeque;

public class TreeNode {
	private ArrayList<TreeNode> children;
	private Object value;
	private ArrayDeque bruh;

	public TreeNode(Object value) {
		this.value = value;
		children = new ArrayList<TreeNode>();
	}
	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	
	public void addChild(Object value) {
		children.add(new TreeNode(value));
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	//returns true if the subTree rooted at this node contains obj
	//needs to be recursive to earn style points
	public boolean contains(Object obj) {
		//YOU DO THIS

		    if (value.equals(obj)) return true;
		    for (TreeNode child : children) {
		        if (child.contains(obj)) return true;
		    }
		    return false;	

	}

	public String toString() {
		return value.toString();
	}
	
	//returns the toString of the subTree rooted at this node
	//needs to be recursive to earn style points
	//order is not important
	public String recursiveToString() {
		//YOU DO THIS
		if (children == null)
		{
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(value.toString() + " ");
		for (TreeNode child : children) {
			sb.append(child.recursiveToString());
		}
		return sb.toString();
	}
}
