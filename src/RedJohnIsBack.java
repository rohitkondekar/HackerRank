import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class RedJohnIsBack {
	
	static boolean[] sieve = new boolean[108644];
	
	static int[] calcSieve(){
		
		Arrays.fill(sieve, true);
		
		sieve[0] = true; //2
		
		for(int i=1;i<sieve.length;i++){
			if(sieve[i]){
				
				int j = i*2+1;
				int val = j+j;
//				System.out.println(j);
				
				
				while(val/2<sieve.length)
				{
					if(val%2!=0)
						sieve[val/2] = false;
					val+=j;
				}
			}
		}
		
		
		int[] counts = new int[217287];
		counts[0] = 0;
		counts[1] = 0;
		counts[2] = 1;
		int sum = 1;
		
		for(int i=3;i<counts.length;i++){
			if(i%2!=0 && sieve[i/2])
				sum++;
			counts[i] = sum;
		}
		
		return counts;
		
		
	}
	

	public static void main(String[] args) throws IOException {
		
		int[] counts = calcSieve();

		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int[] num = new int[41];
		
		num[0] = 1;
		num[1] = 1;
		num[2] = 1;
		num[3] = 1;
		
		for (int i = 4; i < num.length; i++) {
			num[i] = num[i-1]+num[i-4];
		}
		
//		System.out.println(num[9]);
		int T = Integer.parseInt(in.readLine());

		
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			if(N<2)
				out.println(0);
			else
				out.println(counts[num[N]]);
		}
		
		in.close();
		out.close();
		
	}
}
