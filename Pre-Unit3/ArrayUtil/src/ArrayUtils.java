public class ArrayUtils {

	/*
	 * countOdds This method should return the number of odd integers in the array.
	 * Odd integers are not divisible by 2. 0 is an even integer.
	 */
	public static int countOdds(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 != 0)
			{
				answer++;
			}
		}
		return answer;
	}

	/*
	 * onDiagonal This method takes a 2D array of integers, and a single integer
	 * parameter. It returns true if and only if the value of the parameter lies on
	 * a diagonal of the 2D array.
	 * 
	 * Diagonals are illustrated here (X is on diagonal, . is not):
	 * 
	 * X.X X..X X...X .X. .XX. .X.X. etc. X.X .XX. ..X.. X..X .X.X. X...X
	 * 
	 * 2D arrays that are not square do not have diagonals, and should always return
	 * false.
	 */
	public static boolean onDiagonal(int[][] matrix, int test) {
		/* You implement this */
		int startLeft = 0;
		int startRight = matrix[0].length - 1;
		if (matrix.length != matrix[matrix.length - 1].length) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][startLeft] == test) {
				return true;
			}
			if (matrix[i][startRight] == test) {
				return true;
			}
			startLeft++;
			startRight--;

		}
		return false;
	}

	/*
	 * addElements This method takes two 1D integer arrays: list and increment. The
	 * list array is mutated such that the ith element of list will be incremented
	 * by the ith element of increment.
	 * 
	 * e.g. list -> (0, 0, 1, 1, 2, 2) increment -> (4, 5, 6, 7, 8, 9) after
	 * returning, list -> (4, 5, 7, 8, 10, 11)
	 * 
	 * If increment is not as long as list, treat unspecified values as 0.
	 * 
	 * e.g. list -> (0, 0, 1, 1, 2, 2) increment -> (4, 5, 6, 7) after returning,
	 * list -> (4, 5, 7, 8, 2, 2)
	 * 
	 * If increment has more elements than list, ignore the extra elements.
	 */
	public static void addElements(int[] list, int[] increment) {
		/* You implement this */
		if (list.length <= increment.length) {
			for (int i = 0; i < list.length; i++) {
				list[i] = list[i] + increment[i];
			}
		} else {
			for (int i = 0; i < increment.length; i++) {
				list[i] = list[i] + increment[i];
			}
		}

	}

	/*
	 * embiggen Merges two 1D integer arrays into a single 2D integer array. The
	 * [i][j] element of the resulting array is whichever value is larger: array1[i]
	 * or array2[j].
	 */
	public static int[][] embiggen(int[] array1, int[] array2) {
		/* You implement this */
		int[][] embiggedArray = new int[array1.length][array2.length];
		//maybe
		for (int i =0;i< array1.length;i++)
		{
			for (int j= 0; j< array2.length; j++)
			{
				if (array1[i] >= array2[j])
				{
					embiggedArray[i][j] = array1[i];
				}
				else
				{
					embiggedArray[i][j] = array2[j];
				}
			}
		}
		return embiggedArray;
	}

	/*
	 * getPeakIndex A "mountain array" is an array for which there is an index i <
	 * array.length such that the array is strictly increasing before index i, and
	 * decreasing after index i. Index i would be the max, the "peak". If the array
	 * is a mountain array, the index of the peak is returned. If the array is NOT a
	 * mountain array, -1 is returned!
	 */
	public static int getPeakIndex(int[] array) {

		int peak = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[peak])
				peak = i;
		}
		// check doubles
		int doubleCount = 0;
		for (int i = 0; i < array.length; i++) {
			for (int val : array)
			{
			if (array[i] == val) {
				doubleCount++;
			}
			}
			if (doubleCount > 1) {
				return -1;
			}
		}
		
		// mountain check
		for (int i = 0; i < peak - 1; i++) {
			if (array[i] > array[i + 1]) {
				return -1;
			}
		}
		for (int i = peak; i < array.length - 1; i++) {
			if (array[i] < array[i + 1]) {
				return -1;
			}
		}

		return peak;
	}
}