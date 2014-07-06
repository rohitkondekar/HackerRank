import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/sam-and-substrings
 * @author rohitkondekar
 *
 */

public class SamAndSubStrings {

	public static void main(String[] args) throws IOException {

		
		int modval = 1000000007;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str = in.readLine();
		int[] N = new int[str.length()];		
		
		int i = 0;
		while(i<N.length){
			N[i] = Character.getNumericValue(str.charAt(i));
			i++;
		}
		
		long[] S = new long[N.length];
		S[0] = N[0];
		
		long totalSum = S[0];
		
		for (i = 1; i < S.length; i++) {
			S[i] = ((i+1)*N[i] + 10*S[i-1])%(modval);
			totalSum+=S[i];
			totalSum%=modval;
		}
		
		System.out.println(totalSum);
		
		in.close();
		
	}
}
