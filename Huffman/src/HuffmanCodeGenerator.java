import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCodeGenerator {
	
	

	HashMap<Character, Integer> hM = new HashMap<>();
	int[] freq = new int[128];
	public HuffmanCodeGenerator(String inputFile) throws IOException 
	{
		File file = new File(inputFile);
		BufferedReader br = new BufferedReader(new FileReader(file));

		
		while(br.ready())
		{
		
			int c = br.read();
			freq[c]++;
		}
		makeTree();
	}
	public int getFrequency(char c)
	{
		return freq[(int) c];
	}
	//This method should not need the inputFile at all, and should JUST be looking up information in the data structure.
	
	public void makeTree()
	{
		PriorityQueue<HuffmanNode> tree = new PriorityQueue<HuffmanNode>();
		for (int i = 0; i < freq.length; i++)
		{
			if(freq[i] != 0)
			{
				tree.add(new HuffmanNode(i,freq[i]));
			}
		}
		
		while(tree.size() > 1) 
		{			
			HuffmanNode left = tree.remove();
			HuffmanNode right = tree.remove();
			HuffmanNode parent = new HuffmanNode(130, left.getFrequency() + right.getFrequency());
			tree.add(parent);
		}
		HuffmanNode root = tree.remove();
		
		
		
		
	}
	
	//priority queue will always pop out smallest thing
	//make a node for everythign in my array
	//then put all those nodes in priority queue
	//then pop 2 guys out at a time
	
	
	

}
