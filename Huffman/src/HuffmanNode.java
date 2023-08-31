
public class HuffmanNode {

	private int value;
	private int frequency;
	private HuffmanNode left;
	private HuffmanNode right;

	public HuffmanNode(int value, int frequency) {
		this.value = value;
		this.frequency = frequency;

	}

	public int compareTo(HuffmanNode n) {

		if (frequency > n.getFrequency()) {
			return 1;
		}
		else if(frequency < n.getFrequency())
		{
			return -1;
		}
		else {
		return 0;
		}
	}
	
	
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	public HuffmanNode getRight() {
		return right;
	}

	public void setRight(HuffmanNode right) {
		this.right = right;
	}

}
