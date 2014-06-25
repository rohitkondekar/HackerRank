import java.util.Scanner;


/**
 * 
 * @author rohitkondekar
 * https://www.hackerrank.com/challenges/maximizing-xor
 */

public class MaximizingXOR {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int R = in.nextInt();
		
		int tmp = L^R;
		int num=0;
		
		while(tmp!=0){
			tmp>>=1;
			num++;
		}
		
		System.out.println((int)Math.pow(2, num)-1);

	}

}
