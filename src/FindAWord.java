import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://www.hackerrank.com/challenges/find-a-word
 * @author rohitkondekar
 *
 */


public class FindAWord {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int N = Integer.parseInt(in.readLine());
		
		while(N-->0){
			
			StringBuilder str = new StringBuilder();
			boolean status = true;
			
			while(status){
				char c = (char) in.read();
				if((c>=48 && c<=57) || (c>=65 && c<=90) || (c>=97 && c<=122) || c==95){
					str.append(c);
					continue;
				}
				
				if(str.length()>0){
					if(!map.containsKey(str.toString()))
						map.put(str.toString(), 1);
					else
						map.put(str.toString(), map.get(str.toString())+1);
					
					str.delete(0, str.length());
				}
				
				if(c=='\n')
					status=false;
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		while(T-->0){
			String word = in.readLine();
			if(map.containsKey(word))
				out.println(map.get(word));
			else
				out.println(0);
		}
		
		in.close();
		out.close();
	}
}
