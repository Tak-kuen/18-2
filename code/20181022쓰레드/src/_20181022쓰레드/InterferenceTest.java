package _20181022¾²·¹µå;

class Counter {
	private int value=0;
	public void increment() { value++;}
	public void decrement() { value--;}
	public void printCount() { System.out.println(value); }
}

public class InterferenceTest extends Thread{
	Counter sharedCount;
	
	InterferenceTest(Counter c) {
		this.sharedCount=c;
	}
	public void run() {
		for(int i=0; i<1000 ;i++) {
			sharedCount.increment();
			sharedCount.decrement();
		}
		sharedCount.printCount();
	}
	
}
