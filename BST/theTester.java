
public class theTester {

	public static void main(String args[])
	{
		MyBST<Integer> bruh = new MyBST<Integer>();
		MyBST<Integer> bruh3 = new MyBST<Integer>();
		MyBST<String> bruh2 = new MyBST<String>();
		Integer[] ints = {3,9,7,5,4,10,5,6,2,1,8};
		
		String[] strings = {"Ahren", "Asher", "Markus", "Gabe", "Chase", "Allie", "Alexandra",
				"Wyatt", "Alex", "Natalie", "Aidan", "Kian", "Sammy", "Andrew", 
				"Samantha", "Ryan", "Derek", "Micah", "Chris", "Megan", "Mark", "Aidan", "Aaron",
				"Will", "Jake", "Ryan", "Grady", "Ben", "Ronan", "Claire", "Sophia"};
		for (Integer yo : ints)
		{
			bruh.add(yo);
		}
		for (String yo : strings)
		{
			bruh2.add(yo);
		}
		bruh3.add(2);
		System.out.println(bruh.toString());
		System.out.println(bruh2.toString());
		System.out.println(bruh3.toString());
		bruh.remove(7);
		
		bruh.remove(3);
	
		System.out.println(bruh.toString());
		System.out.println(bruh3.toString());
	//	BinaryNode<Integer> oi = new BinaryNode<Integer>(3);
		
	//	System.out.println(bruh.largestOftheLeft(oi).getValue());
		
		

		
		
	}
}
