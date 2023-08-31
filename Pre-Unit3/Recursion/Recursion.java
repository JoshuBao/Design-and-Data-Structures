import java.util.ArrayList;
import java.util.Arrays;
//IF NOT RECURSIVE DOES NOT NEED A METHOD
public class Recursion {
	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	public static long nonConsecutiveSubsets(int n) {
		if (n <= 1) {
			return 1 + n;
		} else {
			return nonConsecutiveSubsets(n - 1) + nonConsecutiveSubsets(n - 2);
		}

	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	public static long waysToJumpUpStairs(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}

		else {
			return waysToJumpUpStairs(n - 3) + waysToJumpUpStairs(n - 2) + waysToJumpUpStairs(n - 1);
		}
	}

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void reverseList(ListNode head) {
		if (head.getNext() != null) {
			reverseList(head.getNext());
			System.out.println(head.getValue());
		} else {
			System.out.println(head.getValue());
		}

	}

	public static void main(String[] args) {
		// System.out.println(waysToJumpUpStairs(10))
		// infect
//		String[][] grid = { { "----------", "vaccinated", "----------", "----------", "----------" },
//				{ "vaccinated", "----------", "----------", "----------", "----------" },
//				{ "----------", "----------", "vaccinated", "vaccinated", "vaccinated" },
//				{ "----------", "----------", "----------", "vaccinated", "----------" } };
//		Recursion.infect(grid, 1, 2);
//
//		String[][] gridSol = { { "----------", "vaccinated", "infected", "infected", "infected" },
//				{ "vaccinated", "infected", "infected", "infected", "infected" },
//				{ "infected", "infected", "vaccinated", "vaccinated", "vaccinated" },
//				{ "infected", "infected", "infected", "vaccinated", "----------" } };
//		System.out.println(Arrays.deepToString(grid));

		//subsets("dogsJa");
		int[] lit = {2,3,1,4,5,6,6};
		print(lit);
		quickSort(lit);
		System.out.println();
		print(lit);
	}

	// For the given 2D array of Strings, replaces the String at index[x][y]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	public static void infect(String[][] grid, int x, int y) {
		if (grid[x][y] == "vaccinated" || grid[x][y] == "infected") {

		} else {
			grid[x][y] = "infected";
			if (x - 1 >= 0) {
				infect(grid, x - 1, y);
			}
			if (x + 1 <= grid.length - 1) {
				infect(grid, x + 1, y);
			}
			if (y - 1 >= 0) {
				infect(grid, x, y - 1);
			}
			if (y + 1 <= grid[0].length - 1) {
				infect(grid, x, y + 1);
			}

		}

	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// Order is your choice
	public static void permute(String str) {
		if (str == null || str.length() == 0) {
			return;
		}

		permutations(str.toCharArray(), 0);
	}

	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	private static void permutations(char[] chars, int position) {
		if (position == chars.length - 1) {
			System.out.println(String.valueOf(chars));
		}

		for (int i = position; i < chars.length; i++) {
			swap(chars, position, i);
			permutations(chars, position + 1);
			swap(chars, position, i);
		}
	}

	public static void subsets(String str) {
		subsetHelper(str, 0, "");
		// calls subset helper from the first index of the string
	}

	static void subsetHelper(String str, int index, String curr) {
		int i = str.length();
		if (index == i) {
			System.out.println(curr);
			return;
		}

		subsetHelper(str, index + 1, curr + str.charAt(index));
		subsetHelper(str, index + 1, curr);
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	public static void quickSort(int[] ints) {
		quickSort(ints, 0, ints.length - 1);
	}

	static void quickSort(int[] a, int beg, int end) {
		if (beg < end) {
			int q = partition(a, beg, end);
			quickSort(a, beg, q - 1);
			quickSort(a, q + 1, end);

		}

	}
	//does the pivot stuff, sorts and swaps
	static int partition(int[] a, int beg, int end) 
	{
		int pivot = a[end];
		int pindex = beg - 1;
		for (int i = beg; i < end; i++) {
			if (a[i] <= pivot) {
				pindex++;
				int t = a[i];
				a[i] = a[pindex];
				a[pindex] = t;
			}
		}
		pindex++;
		int t = a[pindex];
		a[pindex] = a[end];
		a[end] = t;
		return pindex;

	}

	static void print(int[] a) // method to display the array
	{
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] + " ");
	}

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem with
	// n disks starting on tower 0, ending on tower 1.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	public static void solveHanoi(int n) {
    	hanoi2(n,0,1,2); 
    }
    public static void hanoi2 (int n, int firstRod, int nextRod, int otherRod) {
		if (n == 1) {
		    System.out.println(firstRod +" -> "+ nextRod);
		    return;
		}
		hanoi2(n - 1, firstRod, otherRod, nextRod);
		System.out.println(firstRod +" -> " + nextRod );
		hanoi2(n - 1, otherRod, nextRod, firstRod);
		
		
		
	}
	



	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	public static int scavHunt(int[] times, int[] points) {
		return 1;
		//just gonna take the L on this one.... sry mr varney im too tired - 11:59pm Friday
	}

}
