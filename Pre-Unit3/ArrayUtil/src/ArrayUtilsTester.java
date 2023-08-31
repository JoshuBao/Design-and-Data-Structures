import java.util.Arrays;

public class ArrayUtilsTester {

	public static void main(String[] args) {
	
		//test 1
		int[] test1 = {1,-1,-5,10,0,10,6};
		
		System.out.println("test1: " + ArrayUtils.countOdds(test1));
		//test 2
		
		int[][] test2 = {{3,3,3,-2},{3,-2,3,3},{3,3,2,3},{-2,-1,-1,-2}};
		convertToString(test2);
		System.out.println("test2: " + ArrayUtils.onDiagonal(test2,2));
		//test 3
		int[] test3List = {3,2,1};
		int[] test3Increment = {3,2,1};
	
		ArrayUtils.addElements(test3List, test3Increment);
		System.out.println("test3: " + Arrays.toString(test3List));
		//test 4 - embig
		int[] test4List = {5,3};
		int[] test4Increment = {8,1,5};
		System.out.println("Test 4");
		convertToString(ArrayUtils.embiggen(test4List, test4Increment));
		
		
		//test 5 MOUNTAIN
		int[] test5arr = {0,1,2,3,4,4,4,4,4,4};
		System.out.println("Test 5: " + ArrayUtils.getPeakIndex(test5arr));
		
		
		
		
	}
	
	  public static void convertToString(int arr[][]) 
	    { 

	        for (int n = 0 ; n < arr.length ; n++)
	        {
	            System.out.println(Arrays.toString(arr[n])); 
	        } 
	            
	    } 
	
}
 