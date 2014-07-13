import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler001
 * @author rohitkondekar
 *
 */

public class ProjectEuler1_MultiplesOf3and5 {

	
	static BigInteger getSum(long N, int m){
		N = (N-1)/m;
		
		BigDecimal N_ = new BigDecimal(N+"");
		BigDecimal m_ = new BigDecimal(m+"");
		BigDecimal N2_ = new BigDecimal(N/2.0+"");
		
		return N2_.multiply(m_.add(N_.multiply(m_))).toBigInteger();
	}
	
	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			long n = Long.parseLong(in.readLine());
			
			out.println(getSum(n,3).add(getSum(n,5)).subtract(getSum(n,15)));	
		}
		
		
		in.close();
		out.close();
		
		
	}
	
}
