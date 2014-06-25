import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ClosestNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(in.readLine());
		
		int[] array = new int[N];
		StringTokenizer token = new StringTokenizer(in.readLine()," ");
		
		int i=0;
		while(token.hasMoreTokens()){
			array[i++] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(array);
		
		int min = Integer.MAX_VALUE;
		int[] diff = new int[N-1];
		for(i=0;i<array.length-1;i++){
			diff[i] = array[i+1]-array[i];
			if(diff[i]<min)
				min = diff[i];
		}
		
		for (i = 0;  i< diff.length; i++) {
			if(min==diff[i]){
				out.print(array[i]+" "+array[i+1]+" ");
			}
		}
		
		in.close();
		out.close();
	}
}
