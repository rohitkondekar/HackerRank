	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.io.ObjectInputStream.GetField;
	import java.util.Arrays;
	import java.util.StringTokenizer;
	
	/**
	 * https://www.hackerrank.com/challenges/almost-sorted-interval
	 * @author rohitkondekar
	 *
	 *
	 *	We have to find pairs (aL,aR) such that (aL,aR-1)<aR && (aL+1,aR)>aL
	 *  We will keep 2 arrays right[] and left[]
	 *  such that right[i] will have first index right of i with value less than ai
	 *  and left[i] will have first index with value greater than ai
	 *  
	 *  we have to find L&R such that right[L]>R && left[R]<L
	 */
	
	
	public class AlmostSortedInterval {
		
		
		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
			int N = Integer.parseInt(in.readLine());
			
			StringTokenizer token = new StringTokenizer(in.readLine()," ");
			
			int[] array = new int[N];
			int[] left = new int[N];
			int[] right = new int[N];
			
			Arrays.fill(left, -1);
			Arrays.fill(right, N);
			
			int i=0;
	//		while(token.hasMoreTokens()){
	//			array[i++] = Integer.parseInt(token.nextToken());
	//		}
			
	//		System.out.println(Arrays.toString(array));
			
			
			//Using Stack Method to fill left and right array
			int[] stack = new int[N];
			int top = 0;
			
			//left
			for(i=0;i<N;i++){
				array[i] = Integer.parseInt(token.nextToken());
				
				while(top>0 && array[i]>array[stack[top-1]]) --top;
				
				left[i] = top>0?stack[top-1]:-1;
				stack[top++] = i;
			}
			
			top = 0;
			
			//right
			for(i=N-1;i>=0;i--){
				
				while(top>0 && array[i]<array[stack[top-1]])--top;
				
				right[i] = top>0?stack[top-1]:N;
				stack[top++] = i;
			
			}
			
	//		System.out.println(Arrays.toString(left));
	//		System.out.println(Arrays.toString(right));
			
			
			/*
			 * This taking a lot of time - 3 test cases failing due to time
			 * Need to use some interval technique
			 */
			
			int count = 0;
			for(i=0;i<N;i++)
				for(int j=i;j<right[i];j++){
					if(right[i]>j && left[j]<i)
						count++;
				}
			
			System.out.println(count);
			
			in.close();
		}
	}
