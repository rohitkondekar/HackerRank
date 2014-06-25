import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class FindTheMedian {

	
	
	
	static void swap(int[] array, int first, int second){
		int tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}
	
	
	static int partition(int[] array, int start, int end){
		
		Random rnd = new Random();
		int pivot = start+rnd.nextInt(end-start+1);
		
		swap(array,pivot,end);
		pivot = end;
		
		int first = start;
		int last = end-1;
		
		while(first<=last){
			
			while(first<=last && array[first]<array[pivot])
				first++;
			while(first<=last && array[last]>=array[pivot])
				last--;
			
			if(first<last)
				swap(array,first++,last--);
		}
		
		swap(array,first,pivot);
		pivot = first;
		
		return pivot;
		
	}
	
public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);

		int N = Integer.parseInt(in.readLine());
		
		int[] array = new int[N];
		StringTokenizer token = new StringTokenizer(in.readLine()," ");
		
		int i = 0;
		while(token.hasMoreTokens()){
			array[i++] = Integer.parseInt(token.nextToken()); 
		}
		
		
		if(N==1)
		{
			System.out.println(array[0]);
			return;
		}
		
		int start = 0;
		int end = N-1;
		int pivot = partition(array,start,end);
		
		while(pivot!=N/2){
	
			if(pivot>N/2)
				end = pivot-1;
			else
				start = pivot+1;
	
			pivot = partition(array,start,end);
		}
		
		System.out.println(array[N/2]);
		
		in.close();
//		out.close();
	}
	
	
	
	
//	static int partition(int[] array,int start, int end){
//		
////		System.out.println(start+"--"+end+"--"+Arrays.toString(array));
//		
//		if(start==end)
//			return start;
//		
//		int pivot = (start+end)/2;
//		swap(array,pivot,end);
//		
//		pivot = end;
//		
//		int first = start, last = end-1;
//		
//		while(first<=last){
//			
//			while(first <= last && array[first]<array[pivot])
//				first++;
//			
//			
//			while(last >= first && array[last]>=array[pivot]){
//				last--;
//				
//			}
//			
//			if(first<last){
//				swap(array,first,last);
//				first++;
//				last--;
//			}
//		}
//		
//	
//		swap(array,first,pivot);
//		
//		pivot = first;
//		
////		System.out.println("--"+pivot);
//		
//		if(pivot!=array.length/2){
//			if(pivot>array.length/2){
//				return partition(array, start, pivot-1);
//			}
//			else{
//				return partition(array,pivot+1,end);
//			}
//		}
//		
//		return array[pivot];
//	}
	
	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
//
//		int N = Integer.parseInt(in.readLine());
//		
//		int[] array = new int[N];
//		StringTokenizer token = new StringTokenizer(in.readLine()," ");
//		
//		int i = 0;
//		while(token.hasMoreTokens()){
//			array[i++] = Integer.parseInt(token.nextToken()); 
//		}
//		
//		System.out.println(partition(array, 0, N-1));
////		System.out.println(Arrays.toString(array));
//		
//		in.close();
//		out.close();
//	}
}
