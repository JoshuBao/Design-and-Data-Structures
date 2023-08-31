import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class bruh {
  

    HashMap<String, ArrayList<String>> hM = new HashMap<>();
    String seed = "";

    public bruh(String fileName, int chainOrder) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chainOrder; i++) {
            int c = br.read();
            if (c == -1) {
                break;
            }
            sb.append((char) c);
        }
        seed = sb.toString();
        hM.put(seed, new ArrayList<String>());

        while (true) {
            int c = br.read();
            if (c == -1) {
                break;
            }
            String currentChain = sb.toString();
            String nextChar = String.valueOf((char) c);

            if (hM.containsKey(currentChain)) {
                hM.get(currentChain).add(nextChar);
            }
            else {
                hM.put(currentChain, new ArrayList<String>());
                hM.get(currentChain).add(nextChar);
            }

            if (hM.get(currentChain).size() > hM.get(seed).size()) {
                seed = currentChain;
            }


            sb.deleteCharAt(0);
            sb.append(nextChar);
        }

        br.close();
    }

    public void generateText(String outputFileName, int numChars) throws IOException {
        File file = new File(outputFileName);
        PrintWriter pw = new PrintWriter(file);

        pw.print(seed);
        StringBuilder lastChain = new StringBuilder();
        lastChain.append(seed);

 
        for (int i = 0; i < numChars; i++) {
            ArrayList<String> options = hM.get(lastChain.toString());
            if (options == null || options.isEmpty()) {
                break;
            }
            String nextChar = options.get((int) (Math.random() * options.size()));
            pw.print(nextChar);
            lastChain.deleteCharAt(0);
            lastChain.append(nextChar);
        }

        pw.close();
    }
}
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;

//public class MiniGPT {
//	//Style Requirements
//	//can only read the file once
//	//cannot put the file into a string or something similar and then reread the book
//	
//	
//	
//	//bufferedReader.read() letter by letter returns an int
//	//.ready() while(.ready())
//	//.close() at the end
//	
//	HashMap<String, ArrayList<String>> hM = new HashMap<>();
//	String seed = "";
//	public MiniGPT(String fileName, int chainOrder) throws IOException {
//		BufferedReader  br = new BufferedReader(new FileReader(fileName));
//		StringBuilder sb = new StringBuilder();
//		
//		for	(int i = 0; i < chainOrder; i++)
//		{
//			
//			sb.append((char) br.read());
//			
//		}
//		seed=sb.toString();
//		
//		hM.put(sb.toString(), new ArrayList<String>());
////		char monkey = (char) br.read();
////		hM.get(sb.toString()).add(""+ monkey);
//		
//		
//	//	System.out.println(sb.toString());
//		while (br.ready())
//		{
//			//System.out.println(sb.toString());
//			sb.deleteCharAt(0);
//			sb.append((char) br.read());
//			if (hM.containsKey(sb.toString()))
//			{
//				hM.get(sb.toString()).add(""+(char)br.read());
//				
//				if (hM.get(seed).size() < hM.get(sb.toString()).size())
//				{
//					seed = sb.toString();
//				}
//			}
//			
//			else
//			{
//			hM.put(sb.toString(), new ArrayList<String>());
//			
//			hM.get(sb.toString()).add(""+(char)br.read());
//			
//			
//			}
//		}
//		
//		
//		br.close();
//		//System.out.println(hM);
//	}
//	//need a seed
//	//for testing purposes will need a way to print out the hashmap
//	public void generateText(String outputFileName, int numChars) throws IOException {
//		File file = new File(outputFileName);
//		PrintWriter pw = new PrintWriter(file);
//		
//		pw.print(seed);
//		StringBuilder lastChar = new StringBuilder();
//		lastChar.append(seed);
//		
//		for (int i = 0; i < numChars; i++)
//		{
//			ArrayList<String> temp = hM.get(lastChar.toString());
//			//System.out.println(hM.get(lastChar.toString()));
//			
//			System.out.println(temp);
//			String chosen = temp.get((int) (Math.random() * temp.size()));
//			pw.print(chosen);
//			lastChar.deleteCharAt(0);
//			lastChar.append(chosen);
//			
//		}
//		
//		pw.close();
//	}
//	
//	
//	
//	
//	
//}

