import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 * @author rohitkondekar
 *
 */
public class TheLoveLetterMystery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0){
			int ops=0;
			char[] array = in.readLine().toCharArray();
			for(int i=0,j=array.length-1;i<j;i++,j--){
				ops+=Math.abs(array[i]-array[j]);
			}
			out.write(ops+"\n");
		}
		
		out.close();in.close();

	}

}
