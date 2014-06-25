import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/is-fibo
 * @author rohitkondekar
 * 
 * A number is Fibonacci if and only if one or both of (5*n2 + 4) or (5*n2 Ð 4) is a perfect square.
 *
 */
public class IsFibo {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		long[] fib = new long[60];
		fib[0]=0;
		fib[1]=1;
		
		for(int i=2;i<60;i++)
			fib[i] = fib[i-1]+fib[i-2];
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0){
			
			long N = Long.parseLong(in.readLine());
			
			if(Arrays.binarySearch(fib, N)<0)
				out.println("IsNotFibo");
			else
				out.println("IsFibo");
			
		}
		
		in.close();
		out.close();

	}

}
