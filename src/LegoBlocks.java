import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/lego-blocks
//Difficult to understand

//	1. Consider single layer first. It's a generalized length-4 Fibonacci series with
//	F(1) = 1, F(2) = 2, F(3) = 4, F(4) = 8.
//	2. For N layers, and width-M, all possible combinations are F(M)^N.
//	3. Let dp[i] be the optimal solution for width-i, then we have
//	dp[i+1] = F(i+1)^N - sum{dp[1] * F(i)^N, ..., dp[i] * F(1)}.

//	Warning!!
// 1. It overflows quickly. Need BigInteger to store the F-series.
// 2. When calculating the power and multiplication, use the property
//	(a*b) % c = (a%c * b%c) % c (1),
//	(a+b) % c = (a%c + b%c) % c (2),
//	(a-b) % c = (a%c - b%c) % c (3).
//	Be careful, when using property (3), if the result is negative, 
//	add an additional c to the result to make it positive.


public class LegoBlocks {
	
	private static BigInteger modVal = new BigInteger("1000000007");
	private static int mod_num = 1000000007;
	
	private static BigInteger[] singleLayer = new BigInteger[1001];
	private static int[] singleLayerMod = new int[1001];
	
	
	private static long  calculate(int height,int width ){
		
		long[] dp = new long[width+1];
		Arrays.fill(dp, 1);
		
		long[] singleLayerPower = new long[1001];
		for (int i = 0; i < singleLayerMod.length; i++) {
			singleLayerPower[i] = pow_n(singleLayerMod[i],height);
		}
		
		
		for (int i = 1; i <=width; i++) {
			dp[i] = singleLayerPower[i];
			for(int j = 1; j < i; j++)
			{
				dp[i]-=((dp[j]*singleLayerPower[i-j])%mod_num);
				if(dp[i]<0)
					dp[i]+=mod_num;
			}
		}
		
		return dp[width];
	}
	
	//Fast Exponentiation
	 private static long pow_n(int a, int n)
	    {
	    	long result = 1;
	    	long temp = a;
	    	while(n > 0)
	    	{
	    		if((n&1) == 1)
	    		{
	    			result *= temp;
	    			result = (result % mod_num); // Don't write "result %= mod_num"!!!!
	    		}
	    		temp *= temp;
	    		temp %= mod_num;
	    		n = (n >> 1);
	    	}
	    	return result;
	    }
	
	
	public static void main(String[] args) throws IOException {
		
		
		//Calculation for single layer
		// F[i] = F[i-1]+F[i-2]+F[i-3]+F[i-4]
		
		for (int i = 1; i <= 4; i++) {
			singleLayer[i] = new BigInteger(Integer.toString(1<<(i-1)));
		}
		
		for (int i = 5; i < singleLayer.length; i++) {
			singleLayer[i] = singleLayer[i-1].add(singleLayer[i-2]).add(singleLayer[i-3]).add(singleLayer[i-4]);
		}
		
		for (int i = 1; i < singleLayer.length; i++) {
			singleLayerMod[i] = singleLayer[i].mod(modVal).intValue();
		}
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			String[] str = in.readLine().split(" ");
			int height = Integer.parseInt(str[0]);
			int width = Integer.parseInt(str[1]);
			
			if(height==1)
			{
				out.println(width>4?0:1);
				continue;
			}
			
			out.println(calculate(height,width));
			
		}

		in.close();
		out.close();
		
	}

}
