import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.hackerrank.com/challenges/ncr-table
 * @author rohitkondekar
 *
 */


public class nCrTable {
	
	//This Turns out to be approximate
	/*public static String combination(long n, long k)
    {
		
        double sum=0;
        for(long i=0;i<k;i++)
        {
            sum+=Math.log10(n-i);
            sum-=Math.log10(i+1);
        }
        
        BigDecimal bd = new BigDecimal(Math.pow(10, sum));
        String str = bd.toBigInteger().toString();
        
        if(str.length()<=9)
        	return str;
        else
        {
        	return str.substring(str.length()-9);
        }   
     
    }*/
	

	public static void main(String[] args) throws IOException {

		BigInteger[][] mat = new BigInteger[1001][1001];
		mat[0][0] = new BigInteger("1");
		mat[1][0] = new BigInteger("1");
		mat[1][1] = new BigInteger("1");
		
		for(int i=2;i<=1000;i++){
			mat[i][0] = new BigInteger("1");
			for(int j=1;j<i;j++)
				mat[i][j] = mat[i-1][j-1].add(mat[i-1][j]);
			mat[i][i] = new BigInteger("1");
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
	
		int T = Integer.parseInt(in.readLine());
		
		while(T-->0){
			int N = Integer.parseInt(in.readLine());
			for(int i=0;i<=N;i++){
				out.print(mat[N][i].mod(new BigInteger("1000000000"))+" ");
			}
			out.println();
		}
		
		in.close();
		out.close();
	}
}
