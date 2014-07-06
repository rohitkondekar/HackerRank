import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/k-candy-store
 * @author rohitkondekar
 *
 */

public class KCandyStore {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Permutation Table
		 */
		BigInteger[][] mat = new BigInteger[2000][2000];
		mat[0][0] = new BigInteger("1");
		mat[1][0] = new BigInteger("1");
		mat[1][1] = new BigInteger("1");
		
		for(int i=2;i<2000;i++){
			mat[i][0] = new BigInteger("1");
			for(int j=1;j<i;j++)
				mat[i][j] = mat[i-1][j-1].add(mat[i-1][j]).mod(new BigInteger("1000000000"));
			mat[i][i] = new BigInteger("1");
		}
	
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int K = Integer.parseInt(in.readLine());
			
			out.println(mat[N+K-1][K]);
		}
		
		in.close();
		out.close();
		
	}
}
