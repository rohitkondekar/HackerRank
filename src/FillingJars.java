
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FillingJars {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        String[] tmp = in.readLine().split(" ");
        
        long N = Long.parseLong(tmp[0]);
        long M = Long.parseLong(tmp[1]);
        
        long sum = 0;
        
        while(M-->0){
        	tmp = in.readLine().split(" ");
        	sum += ( Long.parseLong(tmp[1])- Long.parseLong(tmp[0])+1)* Long.parseLong(tmp[2]);
        }
        
        out.println(sum/N);
        out.close();
        in.close();
	}

}
