import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/stars
 * @author rohitkondekar
 *
 */
public class Stars {
	
	class Point{
		long x;
		long y;
		long w;
		
		Point(long x,long y, long w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static long linePointPosition(Point P1, Point P2, Point P3){
		
		return (P2.x - P1.x)*(P3.y - P1.y)-(P2.y - P1.y)*(P3.x - P1.x);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PrlongWriter out = new PrlongWriter(System.out);

		Stars star = new Stars();
		
		int N = Integer.parseInt(in.readLine());
		Point[] Points = new Point[N];
		String[] tmp;
		
		int i = 0;
		while(N-->0){
			tmp = in.readLine().split(" ");
			Points[i++] = star.new Point(Long.parseLong(tmp[0]), Long.parseLong(tmp[1]), Long.parseLong(tmp[2]));
		}
		
		long minDiff = Long.MAX_VALUE;
		long minVal = -1;
		long val;
		
		for(i=0;i<Points.length;i++){
			for(int j=0;j<Points.length;j++){
				
				long leftSum = 0;
				long rightSum = 0;
				
				for(int k=0;k<Points.length;k++){
					val = linePointPosition(Points[i], Points[j], Points[k]);
					if(val<0){ //left
						leftSum+=Points[k].w;
					}
					else{
						rightSum+=Points[k].w;
					}
				}
				
				
				long val1,val2,val3,val4;
				//both on one side - left
				
//				val1 = Math.abs(leftSum+Points[i].w + Points[j].w - rightSum); 
//				val2 = Math.abs(rightSum+Points[i].w + Points[j].w - leftSum); 
//				val3 = Math.abs(leftSum+Points[i].w - Points[j].w - rightSum);
//				val4 = Math.abs(leftSum+Points[j].w - Points[i].w - rightSum);
//				
//				val = Math.min(Math.min(Math.min(val1, val2),val3),val4);
				
				val = Math.abs(leftSum-rightSum);
				
				if(val<minDiff){
					minDiff = val;
					minVal = Math.min(leftSum, rightSum);
//					if(val==val1)
//						minVal = (leftSum+Points[i].w+Points[j].w)<=rightSum?(leftSum+Points[i].w+Points[j].w):rightSum;
//						
//					else if (val==val2)
//						minVal = (rightSum+Points[i].w+Points[j].w)<=leftSum?(rightSum+Points[i].w+Points[j].w):leftSum;
//						
//					else if(val==val3)
//						minVal = (leftSum+Points[i].w)<=(rightSum+Points[j].w)?(leftSum+Points[i].w):(rightSum+Points[j].w);
//						
//					else if(val==val4)
//						minVal = (rightSum+Points[i].w)<=(leftSum+Points[j].w)?(rightSum+Points[i].w):(leftSum+Points[j].w);
						
				}
				
//				System.out.println(rightSum+" --- "+leftSum+" -- "+minVal+" -- "+Points[i].w+" -- "+Points[j].w);
				
			}
		}
		
		System.out.println(minVal);
		
		in.close();
//		out.close();
	}

}
