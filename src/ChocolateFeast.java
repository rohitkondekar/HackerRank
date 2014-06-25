import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;


public class ChocolateFeast {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		String[] str;
		
		
		while(T-->0){
			
			str = in.readLine().split(" ");
			int N =  Integer.parseInt(str[0]);
			int C =  Integer.parseInt(str[1]);
			int M =  Integer.parseInt(str[2]);
			
			int tmp = N/C;
			int tmp2;
			int totalChocos = tmp;
			
			while(tmp>=M){
				tmp2 = tmp/M;
				totalChocos +=tmp2;
				tmp = (tmp-tmp2*M)+tmp2;
			}
			
			out.write(totalChocos+"\n");
		}
		
		out.close();in.close();

	}

}
