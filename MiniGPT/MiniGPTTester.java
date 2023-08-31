import java.io.IOException;

public class MiniGPTTester {

	public static void main(String args[]) throws IOException {
		MiniGPT yuh = new MiniGPT("thegreatgatsby.txt", 7);
		yuh.generateText("MUWAHAHAHAHA.txt", 100000);

		MiniGPT yuh2 = new MiniGPT("As I Lay Dying.txt", 8);
		yuh2.generateText("AsIPoopDying.txt", 100000);
		// bruh yuh2 = new bruh("thegreatgatsby.txt",4);
		// yuh2.generateText("hooray.txt", 3000);
	}

}
