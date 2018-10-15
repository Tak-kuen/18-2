package _20181015제네릭;

import java.util.*;

//class Box {
//	private Object data;
//	void set(Object o) { data=o;	}
//	Object get() { return data;	}
//}
class Box<T> {
	private T data;
	void set(T o) { data=o;	}
	T get() { return data;	}
}

public class WDB {
	public static void main(String[] args) {
//	//	String data = "홍길동";
//		Integer data = 10;
//		Box box = new Box();
//		box.set(data);
//		data = (Integer) box.get();
//		String a = (String)box.get();	//오류발생
//		System.out.println(a);
		
//		Box<Integer> bi = new Box<>();
//		Box<String> bs = new Box<>();
//		bi.set(11);
//		bs.set("홍길동");
//		Integer i =bi.get();
//		String s =bs.get();
//		System.out.println(i + s);
		
		ArrayList<String> list = new ArrayList<>();
		list.add("우유");
		list.add("빵");
		list.add("버터");
		for(int i =0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------------");
		list.add(1, "사과");
		Iterator<String> iter = list.iterator();
		for(;iter.hasNext();) {
			System.out.println(iter.next());
		}
		System.out.println("------------------------");
		
		list.remove(2);
		iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("------------------------");
		list.add("사과");
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("------------------------");
		int index = list.indexOf("사과");
		System.out.println(index);
		index= list.lastIndexOf("사과");
		System.out.println(index);
	}
}
