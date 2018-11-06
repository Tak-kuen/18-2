package _20181029쓰레드;

import java.util.ArrayList;

class Buffer {
	private int data;
	private int pos=0;
	private final int MAX=3;
	public ArrayList<Integer> list=new ArrayList<>();
	//버퍼를 3개씩 설정했을때
	
	public boolean isEmpty() {
		if (pos==0)
			return true;
		return false;
	}
	public boolean isFull() {
		if(pos==MAX)
			return true;
		return false;
	}	
	
	public synchronized int get() {
		while(isEmpty()) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		pos--;
		notifyAll();
		return list.get(pos);
	}
	
	public synchronized void put(int data) {
		while(isFull()) {	//버퍼에 상품이 이미 있을경우
			try {		//생산자가 기다려야함
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(-1);list.add(-1);list.add(-1);
		list.set(pos,data);
		pos++;
		notifyAll();
	}
}