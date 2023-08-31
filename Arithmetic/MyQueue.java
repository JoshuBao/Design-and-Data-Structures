import java.util.ArrayList;

public class MyQueue<E> {

	
	private Stack stack1;
	private Stack stack2;
	private int objectCount;
	public MyQueue() {
		
		stack1 = new Stack<E>();
		stack2 = new Stack<E>();
	}

	public E pop() {
		for (int i = 0; i < objectCount; i++)
		{
			stack2.push(stack1.pop());
			
			
		}
		E obj = (E) stack2.pop();
		objectCount--;
		for (int i = 0; i < objectCount; i++)
		{
			stack1.push(stack2.pop());
		}
		return obj;
		
	}

	public void push(E object) {
		stack1.push(object);
		objectCount++;
	}

	public E peek() {
		for (int i = 0; i < objectCount; i++)
		{
			stack2.push(stack1.pop());
			
		}
		E obj = (E) stack2.peek();
		for (int i = 0; i < objectCount; i++)
		{
			stack1.push(stack2.pop());
		}
		return obj;
	}

	public boolean isEmpty() {
		return objectCount == 0;

	}
	
	
}
