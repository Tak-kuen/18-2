package _20181022연결리스트;

import java.util.*;

public class WDB {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		//추가
		list.add("우유");
		list.add("빵");
		list.add("버터");
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		list.set(1,"소보루");
		for(String s : list) {
			System.out.println(s);
		}
		
		System.out.println("========================================");
		
		Map<Integer, String> st = new HashMap<>();
		st.put(1, "홍길동");
		st.put(2, "성춘향");
		
		String a = st.get(1);
		System.out.println(a);
		System.out.println("========================================");
		
		Map<String, String> st1 = new HashMap<>();
		st1.put("홍길동전", "홍길동");
		st1.put("춘향전", "성춘향");
		
		String b = st1.get("춘향전");
		System.out.println(b);
		
		
	}
	
	
}