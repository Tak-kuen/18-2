package _20181022쓰레드;

class Counter {
	private int value=0;
	public synchronized void increment() { value++;}
	// 접근자와 리턴형태 적는사이에 synchronized 키워드 입력해
	// 동기화된 메소드 사용
	// DB에서 RX락 걸리는것과 같은 작용 발생
	public synchronized void decrement() { value--;}
	public synchronized void printCount() { System.out.println(value); }
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