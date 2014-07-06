
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/play-game
 * @author rohitkondekar
 *
 */

public class PlayGame {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			
			int N = Integer.parseInt(in.readLine());
			
			long[] array = new long[N];
			long[] sum = new long[N];
			long[] dp = new long[N];
			
			StringTokenizer token = new StringTokenizer(in.readLine());
			int i = N-1;
			
			while(token.hasMoreTokens()){
				array[i--] = Long.parseLong(token.nextToken());
			}
			
			
			long tmp = 0;
			for(i=0;i<N;i++){
				tmp+=array[i];
				sum[i] = tmp;
			}
			
			
			dp[0] = sum[0];
			dp[1] = sum[1];
			dp[2] = sum[2];
			
			for(i=3;i<N;i++){
				
				long val1 = array[i]+(sum[i-1]-dp[i-1]);
				long val2 = array[i]+array[i-1] +(sum[i-2]-dp[i-2]);
				long val3 = array[i]+array[i-1]+array[i-2] +(sum[i-3]-dp[i-3]);
				
				dp[i] = Math.max(Math.max(val1, val2),val3);
			}
			
			out.println(dp[N-1]);			
			
		}
		
		
		in.close();
		out.close();
		
	}
}
