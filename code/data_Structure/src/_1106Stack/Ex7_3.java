//타입이 정해져있을때
//1501163 송탁근
//
//package _1106Stack;
//
//interface Stack {
//	boolean isEmpty();
//	void push(char item);
//	char pop();
//	void delete();
//	char peek();
//}
//class StackNode {
//	char data;
//	int intData;
//	StackNode link;
//}
//class LinkedStack implements Stack {
//	private StackNode top;
//	
//	@Override
//	public boolean isEmpty() {	return (top==null);}
//
//	@Override
//	public void push(char item) {
//		StackNode newNode = new StackNode();
//		newNode.data=item;
//		newNode.link=top;
//		top=newNode;
//		//System.out.println("Inserted Item : " + item);
//	}//push()
//	
//	public void push(int item) {
//		StackNode newNode = new StackNode();
//		newNode.intData=item;
//		newNode.link=top;
//		top=newNode;
//		//System.out.println("Inserted Item : " + item);
//	}//push()
//
//	@Override
//	public char pop() {
//		if(isEmpty()) {
//			System.out.println("Deleting fail! Linked Stack is empty!!");
//			return 0;
//		} else {
//			char item = top.data;
//			top=top.link;
//			return item;
//		}
//	}//pop()
//	
//	public int pop2() {
//		if(isEmpty()) {
//			System.out.println("Deleting fail! Linked Stack is empty!!");
//			return 0;
//		} else {
//			int item = top.intData;
//			top=top.link;
//			return item;
//		}
//	}//pop()
//
//	@Override
//	public void delete() {
//		if(isEmpty()) {
//			System.out.println("Deleting fail! Linked Stack is empty!!");
//		}else {
//			top=top.link;
//		}
//	}//delete()
//
//	@Override
//	public char peek() {
//		if(isEmpty()) {
//			System.out.println("Peeking fail! Linked Stack is empty!!");
//			return 0;
//		} else {
//			return top.data;
//		}
//	}//peek
//	
//	public void printStack() {
//		if(isEmpty()) {
//			System.out.println("Linked Stack is empty!! \n \n");
//		} else {
//			StackNode temp = top;
//			System.out.println("Linked Stack>> ");
//			while(temp!=null) {
//				System.out.printf("\t %c \n", temp.data);
//				temp = temp.link;
//			}//while
//			System.out.println();
//		}//if-else
//	}//printStack()
//}
//
//class OptExp {
//	private String exp;
//	private int expSize;
//	private char testCh, openPair;
//	
//	public boolean testPair(String exp) {
//		this.exp=exp;
//		LinkedStack S = new LinkedStack();
//		expSize = this.exp.length();
//		for(int i=0; i<expSize ; i++) {
//			testCh = this.exp.charAt(i);
//			switch(testCh) {
//				case '(': case '{': case'[':
//					S.push(testCh); break;
//				case ')': case '}': case']':
//					if(S.isEmpty()) return false;
//					else {
//						openPair = S.pop();
//						if((openPair == '(' && testCh!=')' ) ||
//							(openPair == '{' && testCh!='}') || (openPair == '[' && testCh!=']')) {
//							return false;
//						}else break;//inner inner if-else
//					}//inner if-else
//			}//switch
//		}//for
//		if(S.isEmpty()) return true;
//		else return false;
//	}//testPair
//	
//	public char[] toPostfix(String infix) {
//		char testCh;
//		exp=infix;
//		int expSize=10;
//		int j=0;
//		char postfix[] = new char[expSize];
//		LinkedStack S = new LinkedStack();
//		
//		for(int i=0; i<=expSize;i++) {
//			testCh = exp.charAt(i);
//			switch(testCh) {
//				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case'9':
//					postfix[j++] = testCh; break;
//				case '+': case '-': case '*': case '/':
//					S.push(testCh); break;
//				case')':postfix[j++] = S.pop(); break;
//				default:
//			}//switch
//		}//for
//		postfix[j]=S.pop();
//		return postfix;
//	}//toPostfix
//}//OptExp
//
//class OptExp2 {
//	private String exp;
//	
//	public int evalPostfix(String postfix) {
//		LinkedStack S = new LinkedStack();
//		exp=postfix;
//		int opr1, opr2, value;
//		char testCh;
//		for(int i=0; i<7; i++) {
//			testCh = exp.charAt(i);
//			if(testCh != '+' && testCh != '-' && testCh !='*' && testCh != '/') {
//				value=testCh-'0';
//				S.push(value);
//			}else {
//				opr2 = S.pop2();
//				opr1 = S.pop2();
//				switch(testCh) {
//				case'+' : S.push(opr1+opr2); break;
//				case'-' : S.push(opr1-opr2); break;
//				case'*' : S.push(opr1*opr2); break;
//				case'/' : S.push(opr1/opr2); break;
//				}//switch
//			}//if-else
//		}//for
//		return S.pop2();
//	}
//}
//public class Ex7_3 {
//	public static void main(String[] args) {
//		OptExp opt = new OptExp();
//		String exp = "(3*5)-(6/2)";
//		char postfix[];
//		System.out.println(exp);
//		if(opt.testPair(exp))
//			System.out.println("괄호맞음");
//		else
//			System.out.println("괄호틀림");
//		System.out.printf("\n후위표기식 : ");
//		postfix = opt.toPostfix(exp);
//		System.out.println(postfix);
//		
//		OptExp2 opt2 = new OptExp2();
//		int result;
//		String exp2="35*62/-";
//		System.out.printf("\n후위표기식 : %s", exp2);
//		result=opt2.evalPostfix(exp2);
//		System.out.printf("\n 연산결과 = %d \n", result);
//	}
//}
