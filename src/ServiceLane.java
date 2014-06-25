import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ServiceLane {	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String[] tmp = in.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int T = Integer.parseInt(tmp[1]);
		
		int[] size = new int[N];
		int index=0;
		
		StringTokenizer token = new StringTokenizer(in.readLine()," ");
		while(token.hasMoreTokens()){
			size[index++] = Integer.parseInt(token.nextToken());
		}
		
		while(T-->0){
			tmp = in.readLine().split(" ");
			int min = Integer.MAX_VALUE;
			for(int i=Integer.parseInt(tmp[0]);i<=Integer.parseInt(tmp[1]);i++){
				if(size[i]<min)
					min = size[i];
			}
			out.println(min);
		}

		out.close();
		in.close();
		

		
	}

}
