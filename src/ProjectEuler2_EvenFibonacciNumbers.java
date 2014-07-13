import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler002
 * @author rohitkondekar
 *
 */

public class ProjectEuler2_EvenFibonacciNumbers {

	static long max = (long) (4*Math.pow(10, 16));
	
	public static void main(String[] args) throws IOException {
		
		long[] fibs = new long[81];
		Stack<Long> EvenFibsStck = new Stack<Long>();
		
		//generate fibs
		
		long num1 = 1;
		long num2 = 1;
		long num3;
		long count = 2;
		
		num3 = num2+num1;
		while(num3<max)
		{
			if((num3&1)==0)
				EvenFibsStck.push(num3);
			count++;
			num1=num2;
			num2=num3;
			num3=num1+num2;
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			long N = Long.parseLong(in.readLine());
			BigInteger sum = new BigInteger("0");
			Iterator<Long> it = EvenFibsStck.iterator();
			while(it.hasNext()){
				long tmp = it.next();
				if(tmp<N){
					sum = sum.add(new BigInteger(Long.toString(tmp)));
				}
				else
					break;
			}
			out.println(sum.toString());
		}

		in.close();
		out.close();
		
	}
}
