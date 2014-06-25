
/**
 * https://www.hackerrank.com/challenges/permutation-game
 * @author rohitkondekar
 *
 *	Concept : DP with memoization
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;


public class PermutationGame {
	
	/*
	 * All terminal positions are losing.
	 * If a player is able to move to a losing position then he is in a winning position.
	 * If a player is able to move only to the winning positions then he is in a losing position.
	 */
	
	/*
	 * -1 - not entered yet
	 * 0 - losing position
	 * 1 - wining position
	 */
	static int[] bitArray = new int[32768];
	
	static int unSetBit(int num,int i){
		return num&(~(1<<i));
	}
	
	static int setBit(int num,int i){
		return num|(1<<i);
	}
	
	static boolean isBitSet(int num, int i){
		if(((num>>i)&1)==1)
			return true;
		
		return false;
	}
	
	static int permutation(int[] inArray, int r){
		
		if(bitArray[r]!=-1)
			return bitArray[r];
		
		int last = 0,i;
		for (i = 0; i < inArray.length; i++) {
			if(isBitSet(r, i)){
				if(inArray[i]>last)
					last = inArray[i];
				else
					break;
			}
		}
		
		if(i==inArray.length) // Terminal State = losing state
		{
			bitArray[r] = 0;
			return 0;
		}
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(i=0;i<inArray.length;i++){
			if(isBitSet(r, i))
			{
				set.add(permutation(inArray, unSetBit(r, i)));
			}
		}
		
		if(set.contains(0))
			bitArray[r] = 1;
		else
			bitArray[r] = 0;
		
		return bitArray[r];
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		
		while(T-->0){
			Arrays.fill(bitArray, -1);
			
			int N = Integer.parseInt(in.readLine());
			int[] inArray = new int[N];
			String[] tmp = in.readLine().split(" ");
			for (int i = 0; i < inArray.length; i++) {
				inArray[i] = Integer.parseInt(tmp[i]);
			}
			
			
			int result = permutation(inArray,(1<<N)-1);
			if(result==1)
				out.println("Alice");
			else
				out.println("Bob");
			
			
		}
		
		in.close();
		out.close();
	}

}
