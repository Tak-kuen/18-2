package _20181022¾²·¹µå;

public class ThreadInteference {
	public static void main(String[] args) {
		Counter c = new Counter();
		new InterferenceTest(c).start();
		new InterferenceTest(c).start();
		
	}
}
