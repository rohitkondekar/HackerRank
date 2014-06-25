import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 * https://www.hackerrank.com/challenges/angry-children
 * @author rohitkondekar
 *
 */
public class AngryChildren {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		

		
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int minK = arr[K-1]-arr[0];
		
		for(int i=K;i<N;i++){
			if(arr[i]-arr[i-K+1]<minK){
				minK = arr[i]-arr[i-K+1];
			}
		}
		
		System.out.println(minK);
		
		in.close();
		
	}

}
