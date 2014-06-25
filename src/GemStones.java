import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GemStones {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int[] count = new int[26];
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0;i<N;i++){
			
			boolean[] tmpCount = new boolean[26];
			int c;
			
			while((c=in.read())!='\n' && c>96)
			{				
				if(!tmpCount[c-'a']){
					count[c-'a']++;
					tmpCount[c-'a'] = true;
				}
				
			}

		}

		int sum=0;
		for(int i=0;i<count.length;i++){
			if(count[i]==N)
				sum++;
		}
		System.out.println(sum);
		in.close();
		
	}

}
