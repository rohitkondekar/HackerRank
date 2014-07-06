import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/triangle-numbers
 * @author rohitkondekar
 *
 */

public class TriangleNumbers {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());
		int tmp;
		
		while(T-->0){
			
			int row = Integer.parseInt(in.readLine());
			tmp = row%4;
			if(tmp==0)
				out.println(3);
			else if(tmp==1)
				out.println(2);
			else if(tmp==2)
				out.println(4);
			else if(tmp==3)
				out.println(2);
	
		}
		
		in.close();
		out.close();
		
	}
}
