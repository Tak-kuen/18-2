package _20181022쓰레드;

public class ThreadInteference {
	public static void main(String[] args) {
		Counter c = new Counter();
		new InterferenceTest(c).start();
		new InterferenceTest(c).start();
		
	}
}
