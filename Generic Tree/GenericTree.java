import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
	private TreeNode root;
	
	public GenericTree() {
		root = null;
	}
	
	public GenericTree(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public int size() {
		 int count = 0;
		    Stack<TreeNode> stack = new Stack<>();
		    stack.push(root);
		    while (!stack.isEmpty()) {
		        TreeNode current = stack.pop();
		        count++;
		        for (TreeNode child : current.getChildren()) {
		            stack.push(child);
		        }
		    }
		    return count;
	}
	
	public boolean contains(Object obj) {
		if (root == null) return false;
		//Code this method using recursion in the TreeNode class
		return root.contains(obj);
	}
	
	
	public String toString() {
		// Order is irrelevant:
		// Each TreeNode's contents should be included, on a separate line
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			sb.append(current.toString() + "\n");
			for (TreeNode child : current.getChildren()) {
				queue.add(child);
			}
		}
		return sb.toString();
	}
	
	public String toStringStack() {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			sb.append(current.toString() + "\n");
			for (int i = current.getChildren().size() - 1; i >= 0; i--) {
				stack.push(current.getChildren().get(i));
			}
		}
		return sb.toString();
	}
	
	public String toStringQueue() {
		//Use a queue to do the toString
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			sb.append(current.toString() + "\n");
			for (TreeNode child : current.getChildren()) {
				queue.add(child);
			}
		}
		return sb.toString();
	}
	
	public String toStringRecursion() {
		//Use recursion to do the toString
		return root.recursiveToString();
	}
}
