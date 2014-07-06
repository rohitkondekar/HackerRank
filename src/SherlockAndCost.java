import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * https://www.hackerrank.com/challenges/sherlock-and-cost
 * @author rohitkondekar
 *
 */

public class SherlockAndCost {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			
			int N = Integer.parseInt(in.readLine());
			int[] arrayB = new int[N];
			
			StringTokenizer token = new StringTokenizer(in.readLine()," ");
			int i = 0;
			while(token.hasMoreTokens())
				arrayB[i++] = Integer.parseInt(token.nextToken());
			
			
			//dp[i][0] - max sum till i if arrayA[i] is 1
			//dp[i][1] - max sum till 1 if arrayA[i] is arrayB[i]
			
			long[][] dp = new long[N][2]; 
			
			for(i=1;i<N;i++)
			{
				dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+Math.abs(arrayB[i-1]-1));
				dp[i][1] = Math.max(dp[i-1][0]+Math.abs(arrayB[i]-1), dp[i-1][1]+Math.abs(arrayB[i-1]-arrayB[i]));
			}
			
			out.println(Math.max(dp[N-1][0], dp[N-1][1]));
		}

		in.close();
		out.close();
		
		
	}
}
