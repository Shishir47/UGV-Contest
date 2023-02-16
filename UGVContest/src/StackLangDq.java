import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class StackLangDq {

	public static void main(String[] args) {
		Scanner fs= new Scanner(System.in);
		Deque <Integer> dq= new LinkedList<Integer>();
		boolean rev=false;
		while(fs.hasNext()) {
			String s=fs.next();
			if(s.compareTo("PUSH")==0) {
				
				if(dq.size()>100000 && rev) {
					dq.pollFirst();
					dq.addLast(fs.nextInt());
				}
				else if(dq.size()>100000 && !rev) {
					dq.pollLast();
					dq.addFirst(fs.nextInt());
				}
				else {
					dq.add(fs.nextInt());
				}
				
			} 
			else if (s.compareTo("POP")==0) {
				if(rev) {
					dq.pollFirst();
				}
				else {
					dq.pollLast();
				}
			}
			else if(s.compareTo("PRINT")==0) {
				if(dq.isEmpty()) {
					System.out.println("-");
				}
				else if(!dq.isEmpty() && rev) {
					System.out.println(dq.peekFirst());
				}
				else {
					System.out.println(dq.peekLast());
				}
			}
			else if(s.compareTo("SIZE")==0) {
				System.out.println(dq.size());
			}
			else if(s.compareTo("REVERSE")==0) {
				if(rev==true) {
					rev=false;
				}
				else {
					rev=true;
				}
			}
			else if(s.compareTo("SUM")==0) {
				int sum=0;
				Iterator <Integer> it= dq.iterator();
				while(it.hasNext()) {
					sum=sum+it.next();
				}
				System.out.println(sum);
			}
			else if(s.compareTo("REPEAT")==0) {
				int n=fs.nextInt();
				Deque <Integer> temp= new LinkedList<Integer>();
				Iterator<Integer> it= dq.iterator();
				while(it.hasNext()) {
					temp.add(it.next());
				}
				for(int i=0; i<n; i++) {
					Iterator<Integer> itt= temp.iterator();
					while(itt.hasNext()) {
						if(dq.size()==100000) {
							if(rev)
								dq.pollLast();
							else
								dq.pollFirst();
						}
						if(rev) {
							dq.addFirst(itt.next());
						}
						else {
							dq.addLast(itt.next());
						}
						
						
					}
				}
			}
		}
		fs.close();
	}
}
