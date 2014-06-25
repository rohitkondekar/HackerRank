import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.hackerrank.com/challenges/halloween-party
 * @author rohitkondekar
 *
 */
public class HalloweenParty {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		long tmp;
		
		while(T-->0){
			
			int K = Integer.parseInt(in.readLine());
			tmp = K/2;
			
			if(K%2==0){
				out.write(tmp*tmp+"\n");
			}
			else{
				out.write(tmp*(tmp+1)+"\n");				
			}
		}
		out.close();
		in.close();
		

	}

}
