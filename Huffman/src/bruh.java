
public class bruh {
	public static void squareArray() {
	    int[] arr = new int[1000000];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = i + 1;
	    }
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = arr[i] * arr[i];
	    }
	}

	public static void main(String[] args) {
	    long startTime = System.nanoTime();
	    squareArray();
	    long endTime = System.nanoTime();
	    long elapsedTime = endTime - startTime;
	    double seconds = (double) elapsedTime / 1_000_000_000.0;
	    System.out.println("Elapsed Time: " + seconds + " seconds");
	}

	
	
	
	
	
	
}
