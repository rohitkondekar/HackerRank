import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class FindDigits {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());
		while(T-->0){
			ArrayList<Integer> list = new ArrayList<Integer>(10);
			StringBuilder str = new StringBuilder();
			char c = (char) in.read();
			while(c!=-1 && c!='\n' && c>47 && c<58){
				list.add(Character.getNumericValue(c));
				str.append(c);
				c = (char) in.read();
			}
			
			long num = Long.parseLong(str.toString());
			int total = 0;
			for(int i=0;i<list.size();i++){
				if(list.get(i)==1 || (list.get(i)!=0 && num%list.get(i)==0))
					total++;
			}
			
			out.println(total);
		}
		
		
		in.close();
		out.close();
	}

}
