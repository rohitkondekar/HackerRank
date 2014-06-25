import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ManasaAndStones {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0){
			
			ArrayList<Integer> list = new ArrayList<Integer>(10);
			
			int n = Integer.parseInt(in.readLine());
			int a = Integer.parseInt(in.readLine());
			int b = Integer.parseInt(in.readLine());
			int sum;
			
			if(a>b){
				sum = a;
				a = b;
				b = sum;
			}
			
			if(n==1){
				list.add(0);
			}
			else if(a!=b){
				
				for(int i=0;i<n;i++){
					sum = (n-1-i)*a+i*b;
					if(list.isEmpty() || list.get(list.size()-1)!=sum)
						list.add(sum);
				}
			}
			else{
				list.add((n-1)*a);
			}
			
			Iterator<Integer> it = list.iterator();
			while(it.hasNext())
				out.write(it.next()+" ");
			
			out.write("\n");
			
			
		}
		
		
		out.close();
		in.close();

	}

}
