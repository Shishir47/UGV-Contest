import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackLang{

	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		//FastScanner fs= new FastScanner();
		Scanner fs= new Scanner(System.in);
		Stack <Integer> st= new Stack<Integer>();

		while(fs.hasNext()) {
			String ss=fs.next();
			if(st.size()==1000000) {
				st.pop();
			}
			if(ss.compareTo("PUSH")==0) {
				st.add(fs.nextInt());
			}
			else if(ss.compareTo("POP")==0) {
				if(!st.isEmpty())
				st.pop();
			}
			else if(ss.compareTo("PRINT")==0) {
				if(st.isEmpty())
					out.println("-");
				else
				out.println(st.peek());
			}
			else if(ss.compareTo("REVERSE")==0) {
				Queue <Integer> temp=new LinkedList<Integer>();
				while(!st.isEmpty()) {
					temp.add(st.pop());
				}
				while(!temp.isEmpty()) {
					st.push(temp.poll());
				}
				
			}
			else if(ss.compareTo("SIZE")==0) {
				out.println(st.size());
			}
			else if(ss.compareTo("REPEAT")==0) {
				if(!st.isEmpty()) {
					int x=fs.nextInt();
					Stack <Integer> temp=st;
					for(int i=1000000; i<=st.size(); i++) {
						st.pop();
					}
					for(int i=0; i<x; i++) {
						st.addAll(temp);
					}
				}
			}
			else if(ss.compareTo("SUM")==0) {
				if(st.isEmpty()) {
					out.println(0);
				}
				else {
					int sum=0;
					while(!st.isEmpty()) {
						sum=sum+st.pop();
					}
					out.println(sum);
				}
			}
			
		}
		
		out.close();
		System.gc();
		
		
		
	}
	 static int knapSack(int W, int wt[], int val[], int n)
	    {
	   
	        int[] dp = new int[W + 1];
	 
	        for (int i = 1; i < n + 1; i++) {
	            for (int w = W; w >= 0; w--) {
	 
	                if (wt[i - 1] <= w)
	 
	                    
	                    dp[w]
	                        = Math.min(dp[w], dp[w - wt[i - 1]]
	                                              + val[i - 1]);
	            }
	        }
	        return dp[W];
	                     
	    }
	 
	 static int tsp(int[][] graph, boolean[] v,
             int currPos, int n,
             int count, int cost, int ans)
{

  if (count == n && graph[currPos][0] > 0)
  {
      ans = Math.min(ans, cost + graph[currPos][0]);
      return ans;
  }

  for (int i = 0; i < n; i++)
  {
      if (v[i] == false && graph[currPos][i] > 0)
      {
          v[i] = true;
          ans = tsp(graph, v, i, n, count + 1,
                    cost + graph[currPos][i], ans);
          v[i] = false;
      }
  }
  return ans;
}
	
	static final Random random=new Random();
	static final int mod=1_000_000_007;
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static long add(long a, long b) {
		return (a+b)%mod;
	}
	static long sub(long a, long b) {
		return ((a-b)%mod+mod)%mod;
	}
	static long mul(long a, long b) {
		return (a*b)%mod;
	}
	static long exp(long base, long exp) {
		if (exp==0) return 1;
		long half=exp(base, exp/2);
		if (exp%2==0) return mul(half, half);
		return mul(half, mul(half, base));
	}
	static long[] factorials=new long[2_000_001];
	static long[] invFactorials=new long[2_000_001];
	static void precompFacts() {
		factorials[0]=invFactorials[0]=1;
		for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
		invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
		for (int i=invFactorials.length-2; i>=0; i--)
			invFactorials[i]=mul(invFactorials[i+1], i+1);
	}
	
	static long nCk(int n, int k) {
		return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	//Fast Scanner
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try { 
					st=new StringTokenizer(br.readLine());				               
				} catch (IOException e) {}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextL() throws IOException {
			return br.readLine();
		}
    }
    

} 
