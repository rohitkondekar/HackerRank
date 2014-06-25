import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 * https://www.hackerrank.com/challenges/candies
 * 
 */
public class Candies {

	
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);

		int N = Integer.parseInt(in.readLine());
		int[] array = new int[N];
		int[] candies = new int[N];
		
		Arrays.fill(candies, 1);
		
		boolean changes = true;
		
		
		for (int i = 0; i < array.length; i++){
			array[i] = Integer.parseInt(in.readLine());
		}
		
		while(changes){
			changes = false;
			
			for (int i = 0; i < array.length; i++) {
				
				if(i-1>=0 && array[i]>array[i-1] && candies[i]<=candies[i-1]){
					candies[i] = candies[i-1]+1;
					changes = true;
				}
				
				if(i+1<array.length && array[i]>array[i+1] && candies[i]<=candies[i+1]){
					candies[i] = candies[i+1]+1;
					changes = true;
				}
				
			}
		}
		
//		System.out.println(Arrays.toString(candies));
		
		int totalSum = 0;
		for (int i = 0; i < candies.length; i++) {
			totalSum+=candies[i];
		}

		
		
		System.out.println(totalSum);
		
		in.close();

	}

}
