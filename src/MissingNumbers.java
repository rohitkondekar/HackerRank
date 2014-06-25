import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MissingNumbers {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int[] set = new int[1000002];
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer token = new StringTokenizer(in.readLine()," ");
		
		while(token.hasMoreTokens()){
			set[Integer.parseInt(token.nextToken())]++;
		}
		
		int M = Integer.parseInt(in.readLine());
		token = new StringTokenizer(in.readLine()," ");
		
		while(token.hasMoreTokens()){
			set[Integer.parseInt(token.nextToken())]--;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<set.length;i++){
			if(set[i]<0)
				list.add(i);
		}
		
		Collections.sort(list);
		
		
		for(int i=0;i<list.size()-1;i++){
			out.print(list.get(i)+" ");
		}
		out.print(list.get(list.size()-1));
		
		in.close();
		out.close();
		
	}
}
