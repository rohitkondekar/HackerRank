import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 * @author rohitkondekar
 *
 */
public class SherlockandTheBeast {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());
		
		while(T-->0){
			
			int N = Integer.parseInt(in.readLine());
			
			int Num3 = 0;
			
			while(!(N%3==0 && Num3%5==0) && N>0){
				Num3+=5;
				N-=5;
			}
			
			if(N<0)
			{
				out.write("-1\n");
				continue;
			}
			
			StringBuilder str = new StringBuilder();
			for(int i=0;i<N;i++)
				str.append("5");
			for(int i=0;i<Num3;i++)
				str.append("3");
			
			out.write(str.toString()+'\n');
			
		}
		
		in.close();
		out.close();

	}

}
