import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ByteCounter {
	
	private int bCount = 0;
	public ByteCounter(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
		int yuh[] = new int[8];
		while (br.ready())
		{
			sb.append((char) br.read());
			if (sb.toString().equals("A"))
			{
				yuh[0] ++;
			}
			else if (sb.toString().equals("B"))
			{
				yuh[1] ++;
			}
			else if (sb.toString().equals("C"))
			{
				yuh[2] ++;
			}
			else if (sb.toString().equals("D"))
			{
				yuh[3] ++;
			}
			else if (sb.toString().equals("E"))
			{
				yuh[4] ++;
			}
			else if (sb.toString().equals("F"))
			{
				yuh[5] ++;
			}
			else if (sb.toString().equals("G"))
			{
				yuh[6] ++;
			}
			else if (sb.toString().equals(" "))
			{
				yuh[7] ++;
			}
			
			
//			if (sb.toString().equals("A") || sb.toString().equals("E"))
//			{
//				bCount += 2;
//			}
//			if (sb.toString().equals(" ") || sb.toString().equals("G"))
//			{
//				bCount += 3;
//			}
//			if (sb.toString().equals("B") || sb.toString().equals("C"))
//			{
//				bCount += 4;
//			}
//			if (sb.toString().equals("A") || sb.toString().equals("D"))
//			{
//				bCount += 5;
//			}
			sb.deleteCharAt(0);
		}
		for (int i = 0; i < yuh.length; i++)
		{
			System.out.println(yuh[i]);
		}
		bCount += 2*(yuh[7] + yuh[0]);
		bCount += 3*(yuh[4] + yuh[3]);
		bCount += 4*(yuh[1] + yuh[5]);
		bCount += 5*(yuh[2] + yuh[6]);
		
		
		
		System.out.println(bCount);
		
	}
	
	
}
