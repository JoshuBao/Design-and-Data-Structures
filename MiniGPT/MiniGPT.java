import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class MiniGPT {

	HashMap<String, ArrayList<String>> hM = new HashMap<>();
	String seed = "";

	public MiniGPT(String fileName, int chainOrder) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chainOrder; i++) {
			int lilMonk = br.read();
		
			sb.append((char) lilMonk);
		}
		seed = sb.toString();
		hM.put(seed, new ArrayList<String>());

		while (br.ready()) {

			String curr = sb.toString();
			String nextChar = String.valueOf((char) br.read());

			if (hM.containsKey(curr)) {
				hM.get(curr).add(nextChar);
			} else {
				hM.put(curr, new ArrayList<String>());
				hM.get(curr).add(nextChar);
			}

			if (hM.get(curr).size() > hM.get(seed).size()) {
				seed = curr;
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