import java.io.File;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayDeque;

/* You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make stacks and queues,
 * and Java's PriorityQueue class to make a priority queue */

public class CookieMonster {

	private int[][] cookieGrid;
	private int numRows;
	private int numCols;

	// Constructs a CookieMonster from a file with format:
	// numRows numCols
	// <<rest of the grid, with spaces in between the numbers>>
	public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try {
			Scanner input = new Scanner(new File(fileName));

			numRows = input.nextInt();
			numCols = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++)
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();

			input.close();
		} catch (Exception e) {
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

	}

	public CookieMonster(int[][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows = cookieGrid.length;
		this.numCols = cookieGrid[0].length;
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies. Returns the
	 * maximum number of cookies attainable.
	 */
	public int recursiveCookies() {
		return rcHelper(0, 0, 0);
	}

	public int rcHelper(int row, int col, int tot) {

		if (!safe(row, col)) {
			return 0;
		}

		int recur2 = rcHelper(row + 1, col, tot + cookieGrid[row][col]);

		int recur3 = rcHelper(row, col + 1, tot + cookieGrid[row][col]);

		if (tot + cookieGrid[row][col] > recur2 && tot + cookieGrid[row][col] > recur3) {
			return tot + cookieGrid[row][col];
		} else if (recur2 < recur3) {
			return recur3;
		} else {
			return recur2;
		}
	}

	public boolean safe(int row, int col) {
		if (row >= cookieGrid.length || col >= cookieGrid[0].length) {
			return false;
		}
		if (cookieGrid[row][col] <= -1) {
			return false;
		}
		return true;
	}

	/*
	 * Calculate which route grants the most cookies using a QUEUE. Returns the
	 * maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int queueCookies() {
		if (!safe(0, 0)) {
			return 0;
		}
		ArrayDeque<OrphanScout> lilHomie = new ArrayDeque<OrphanScout>();
	
		OrphanScout oliverTwistAhh = new OrphanScout(0, 0, cookieGrid[0][0]);
		
		int max = 0;
		
		lilHomie.add(oliverTwistAhh);
		
		while (!lilHomie.isEmpty()) 
		{
			
			OrphanScout p = lilHomie.peek();
			int row = p.getEndingRow();
			int col = p.getEndingCol();
			int total = p.getCookiesDiscovered();
			lilHomie.remove();

			if (safe(row + 1, col)) 
			{
				OrphanScout temp = new OrphanScout(row +1, col, total+cookieGrid[row+1][col]);
				lilHomie.add(temp);
			}
			if (safe(row, col+1)) 
			{
				OrphanScout temp = new OrphanScout(row, col + 1, total+cookieGrid[row][col+1]);
				lilHomie.add(temp);
			}
			if (total>max)
			{
				max = total;
			}

		}
		return max;
		
		
		
	}

	/*
	 * Calculate which route grants the most cookies using a stack. Returns the
	 * maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int stackCookies() {
		if (!safe(0, 0)) {
			return 0;
		}
		LinkedList<OrphanScout> lilHomie = new LinkedList<OrphanScout>();
	
		OrphanScout oliverTwistAhh = new OrphanScout(0, 0, cookieGrid[0][0]);
		
		int max = 0;
		
		lilHomie.add(oliverTwistAhh);
		
		while (!lilHomie.isEmpty()) 
		{
			
			OrphanScout p = lilHomie.get(0);
			int row = p.getEndingRow();
			int col = p.getEndingCol();
			int total = p.getCookiesDiscovered();
			lilHomie.pop();

			if (safe(row + 1, col)) 
			{
				OrphanScout temp = new OrphanScout(row +1, col, total+cookieGrid[row+1][col]);
				lilHomie.push(temp);
			}
			if (safe(row, col+1)) 
			{
				OrphanScout temp = new OrphanScout(row, col + 1, total+cookieGrid[row][col+1]);
				lilHomie.push(temp);
			}
			if (total>max)
			{
				max = total;
			}

		}
		return max;
	}

	/*
	 * Calculate which route grants the most cookies using a priority queue. Returns
	 * the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int pqCookies() {
		if (!safe(0, 0)) {
			return 0;
		}
		PriorityQueue<OrphanScout> lilHomie = new PriorityQueue<OrphanScout>();
	
		OrphanScout oliverTwistAhh = new OrphanScout(0, 0, cookieGrid[0][0]);
		
		int max = 0;
		
		lilHomie.add(oliverTwistAhh);
		
		while (!lilHomie.isEmpty()) 
		{
			
			OrphanScout p = lilHomie.peek();
			int row = p.getEndingRow();
			int col = p.getEndingCol();
			int total = p.getCookiesDiscovered();
			lilHomie.remove();

			if (safe(row + 1, col)) 
			{
				OrphanScout temp = new OrphanScout(row +1, col, total+cookieGrid[row+1][col]);
				lilHomie.add(temp);
			}
			if (safe(row, col+1)) 
			{
				OrphanScout temp = new OrphanScout(row, col + 1, total+cookieGrid[row][col+1]);
				lilHomie.add(temp);
			}
			if (total>max)
			{
				max = total;
			}

		}
		return max;
		
	}

}
