import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003
 * @author rohitkondekar
 * Generate primes using seive of erthro till sqrt(N) 
 * divide N till factor>N
 *
 */


public class ProjectEuler3_LargestPrimeFactor {
	
	static long max = (long) Math.pow(10, 12);
	static int maxSqrt = (int) Math.sqrt(max);
	
	public static void main(String[] args) throws IOException {
		
		boolean[] sievePrimes = new boolean[maxSqrt+1];
		Arrays.fill(sievePrimes, true);
		sievePrimes[0] = sievePrimes[1] = false;
		
		Stack<Integer> primes = new Stack<Integer>();
		
		for (int i = 2; i < sievePrimes.length; i++) {
			if(sievePrimes[i])
			{
				primes.push(i);
				for (int j = 2; i*j<sievePrimes.length; j++) {
					sievePrimes[i*j]=false;
				}
			}
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());


		while (T-- > 0) {
			long N = Long.parseLong(in.readLine());
			
			Iterator<Integer> it = primes.iterator();
			int factor = it.next();
			while(factor<N){
				while(factor<N && N%factor==0)
					N/=factor;
				if(!it.hasNext())
					break;
				factor = it.next();
			}
			
			out.println(N);
		}

		in.close();
		out.close();
		
	}
}
