import java.util.ArrayList;

public class MyArrayListTester {

	public static void main(String[] args) {
		
//		MyArrayList<String> testList = new MyArrayList<String>(3);
//		
//		testList.add("lilbop");
//
//		System.out.println("testList:" + testList);
//		testList.add("munger");
//		testList.add("bar");
//		testList.add("munger");
//		testList.add("munger");
//		testList.add("bar");
//		testList.add("munger");
//		testList.add("bar");
//		testList.add("bar");
//		testList.add("bar");
//		testList.add("bar");
//		
//		testList.remove(5);
//
//
//		
//		System.out.println("testList:" + testList);
//		testList.remove("munger");
//		System.out.println("testList:" + testList);
//		
//		
//		testList.moveToBack("munger");
//		
//		
//		System.out.println("testList hi mr varnye:" + testList);
//		
//		System.out.println("size:" + testList.size());
//		System.out.println("isEmpty:" + testList.isEmpty());
//		System.out.println("testList contains:" + testList.contains("munger"));
//		
//		System.out.println("\n \n \n");
//		
//		
//		
		ArrayList<String> words = new ArrayList<String>(100);
		words.add("wordy");
//		words.add("monk");
//		words.add("monk");
//		words.remove("ddfd");
//		words.add("monk");
		words.add(1,"litMonk");
		System.out.println("wordSize:" + words.size());
		System.out.println("words:" + words);
		
		ArrayList<String> wordy = new ArrayList<String>();
		wordy.add("woo");
		wordy.add(1,"dfd");
		System.out.println("wordy:" + wordy);
//		
//		testList.remove("ojlkjljkj");
//		//words.set(300, "lol");
//		System.out.println("words:" + words);
//		System.out.println("wordContains:" + words.contains("mon"));
//		
//
//		ArrayList<Integer> nums = new ArrayList<Integer>(100);
//		nums.add(1);
//		nums.add(2);
//		System.out.println("nums:" + nums);
//		nums.remove(1);
//		System.out.println("nums:" + nums);
//	
//		MyArrayList<Integer> myNums = new MyArrayList<Integer>();
//		myNums.add(1);
//		myNums.add(2);
//		System.out.println("myNums:" + myNums);
//		myNums.remove(1);
//		System.out.println("myNums:" + myNums);

		
		
//		ArrayList list = new ArrayList<String>(10);
//		MyArrayList mylist = new MyArrayList<String>(10);
//
//		mylist.add("A");
//		mylist.add("B");
//		mylist.add("C");
//		mylist.add("D");
//		mylist.add("E");
//		mylist.add("F");
//		mylist.add("G");
//		
//		
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		list.add("D");
//		list.add("E");
//		list.add("F");
//		list.add("G");
//		
//		System.out.println("Original myList:" + mylist);
//		System.out.println("Original list:" + list);
//		
//		mylist.remove("A");
//		list.remove("A");
//		System.out.println("myList after remov A:" + mylist);
//		System.out.println("list after remov A:" + list);
//		
//		mylist.remove("F"); 
//		list.remove("F");
//		System.out.println("myList after remove F:" + mylist);
//		System.out.println("list after remove F:" + list);
		
//		
//		
//		MyArrayList<Integer> ints = new MyArrayList<Integer>();
//		//Set max to 10000000 for an efficiency check, or 100 for an accuracy check
//		int max = 100;
//		for (int i = 0; i < max; i++)
//		{
//		if (i % 5 == 0 || i % 17 == 0)
//		ints.add(new Integer(1));
//		else
//		ints.add(new Integer(2));
//		}
//		System.out.println("ints:" + ints);
//		long startTime = System.currentTimeMillis();
//		ints.moveToBack(new Integer(1));
//		
//		long totalTime = System.currentTimeMillis() - startTime;
//		System.out.println("ints:" + ints);
//		System.out.println("Total milliseconds for moveToBack is " + totalTime);
//		boolean mistake = false;
//		for (int i = 0; !mistake && i < max*6/10; i++)
//		{
//		if (ints.get(i).equals(new Integer(1)))
//		{
//			mistake = true;
//		}
//		//System.out.print(mistake + "dfdfed" + ints.get(i) + new Integer(1));
//		}
//		if (!mistake)
//		{
//		System.out.println("Probably correct!");
//		}
//		else
//		{
//		System.out.println("Incorrect!");
//		}
//		
//		
//		
//		
//	  	MyArrayList mylist = new MyArrayList<String>();
//    	mylist.add("A");
//    	mylist.add("B");
//    	mylist.add("A");
//    	mylist.add("C");
//    	mylist.add("D");
//    	mylist.add("A");
//    	mylist.add("A");
//    	mylist.add("E");
//    	mylist.add("F");
//    	mylist.add("G");
//    	mylist.add("A");
//    	mylist.moveToBack("A");
//    	
//    	ArrayList list = new ArrayList<String>();
//    	list.add("B");
//    	list.add("C");
//    	list.add("D");
//    	list.add("E");
//    	list.add("F");
//    	list.add("G");
//    	list.add("A");
//    	list.add("A");
//    	list.add("A");
//    	list.add("A");
//    	list.add("A");
//        System.out.println("homies sizes are equal" + (list.size() == mylist.size()));
//        
////        for (int i = 0; i < list.size(); i++) {
////            assertNotNull(mylist.get(i));
////            assertEquals(list.get(i), mylist.get(i));
////        }
//        System.out.println("test" + list);
//        System.out.println("my homie" + mylist);
        
	}
	
	
}
