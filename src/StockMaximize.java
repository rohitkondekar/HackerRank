import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/stockmax
 * @author rohitkondekar
 *
 */

public class StockMaximize {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());
		
		while(T-->0){
			int N = Integer.parseInt(in.readLine());
			
			if(N==1)
			{
				out.println(0);
				continue;
			}
			
			long[] array = new long[N];
			
			StringTokenizer token = new StringTokenizer(in.readLine()," ");
			int i = 0;
			while(token.hasMoreTokens())
				array[i++] = Integer.parseInt(token.nextToken());
	
			
			int end = array.length-1;
			int start=-1;
			long sum=0, profitSum=0;
			
			for(i=array.length-2;i>=0;i--){
				if(array[i]<array[end])
				{
					sum-=array[i];
					continue;
				}
				
				start = i+1;
				if(start!=end){
					profitSum+=sum+(end-start)*array[end];
				}
				
				sum = 0;
				end = i;
				start = -1;
			}
			
			if(start==-1 && end!=0){
				profitSum+=sum+end*array[end];
			}
			
			out.println(profitSum);
		}
		
		in.close();
		out.close();
	}

}
