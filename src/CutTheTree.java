import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/cut-the-tree
 * @author rohitkondekar
 * 
 * Use DFS to store values of subtree
 * let W be the weight of whole tree
 * then find appropriate edge using O(n)
 * 
 * Total order would be O(2n)
 *
 */
public class CutTheTree {
	
	
	static long totalWeight;
	static int[] vertices;
	static boolean[] visited;
	static long[] weightSubTree;
	static long[] val_node;
	
	
	static ArrayList<Stack<Integer>> edges;
	
	public static long dfs(int index){
		
		if(visited[index])
			return 0;
		
		long sum = vertices[index];
		Stack<Integer> stck = edges.get(index);
		visited[index] = true;
		
		Iterator<Integer> it = stck.iterator();
		
		while(it.hasNext()){
			int tmp = it.next();
			sum+=dfs(tmp);
		}
		
		return (weightSubTree[index] = sum);
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int N = Integer.parseInt(in.readLine().trim());
		vertices = new int[N+1];
		visited = new boolean[N+1];
		weightSubTree = new long[N+1];
		val_node = new long[N+1];
		edges = new ArrayList<Stack<Integer>>(N+1);
		edges.add(new Stack<Integer>());//for location 0;
		
		StringTokenizer token = new StringTokenizer(in.readLine().trim()," ");
		int i = 1;
		while(token.hasMoreTokens()){
			vertices[i] = Integer.parseInt(token.nextToken());
			totalWeight+= vertices[i];
			edges.add(new Stack<Integer>());
			i++;
		}
		
		
		i = N-1;
		String[] tmp;
		
		while(i-->0){
			tmp = in.readLine().split(" ");
			int vert1 = Integer.parseInt(tmp[0]);
			int vert2 = Integer.parseInt(tmp[1]);
			edges.get(vert1).push(vert2);
			edges.get(vert2).push(vert1);
		}

		
		int root = 1;
		
		for (int j = 0; j < edges.size(); j++) {
			
			if(!edges.get(j).isEmpty()){
				root = j;
				break;
			}
		}
		
		dfs(root);
		
		for (int j = 0; j < weightSubTree.length; j++) {
			val_node[j] = Math.abs((totalWeight - weightSubTree[j]) - weightSubTree[j]);
		}
		
		//System.out.println(Arrays.toString(val_node));
		Arrays.sort(val_node);
		
		System.out.println(val_node[0]);
		
		

		in.close();
		out.close();
	}
	
}
	
	
	/* 
	 * Tree structure with appropriate input --- but input is a problem
	 * so solving like undirected graph using visited and stuff.
	 * 
	 */
//
//	static long totalWeight = 0;
//	
//	class Node{
//		int val;
//		long valueOfSubtree;
//		ArrayList<CutTheTree.Node> children =  new ArrayList<CutTheTree.Node>();
//		
//	}
//	
//	
//	static long dfs(Node root){
//		
//		if(root.children.size()==0){
//			root.valueOfSubtree = root.val;
//			System.out.println(root.val);
//			return root.valueOfSubtree;
//		}
//		
//		Iterator<Node> it = root.children.iterator();
//		long sum = root.val;
//		
//		while(it.hasNext())
//		{
//			sum+=dfs(it.next());
//		}
//		
//		root.valueOfSubtree = sum;
//		return root.valueOfSubtree;
//	
//	}
//	
//	
//	
//	static long checkDFS(Node root){
//		
//		long min = Long.MAX_VALUE;
//		if(root.children.size()==0){
//			return min;
//		}
//		
//		Iterator<Node> it = root.children.iterator();
//		long tmp;
//		
//		while(it.hasNext()){
//			Node N = it.next();
//			tmp = (totalWeight - N.valueOfSubtree) - N.valueOfSubtree;
//			if(tmp<min)
//				min = tmp;
//			
//			tmp = checkDFS(N);
//			if(tmp<min)
//				min = tmp;
//		}
//
//		return min;
//	}
//	
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
//
//		
//		CutTheTree ct = new CutTheTree();
//		int N = Integer.parseInt(in.readLine().trim());
//		
//		Node[] vertices = new Node[N+1];
//		
//		StringTokenizer token = new StringTokenizer(in.readLine().trim()," ");
//		int i=1;
//		
//		while(token.hasMoreTokens()){
//			vertices[i] = ct.new Node();
//			vertices[i].val = Integer.parseInt(token.nextToken());
//			totalWeight+=vertices[i].val;
//			i++;
//		}
//		
//		i = N-1;
//		String[] tmp;
//		
//		while(i-->0){
//			tmp = in.readLine().split(" ");
//			vertices[Integer.parseInt(tmp[0])].children.add(vertices[Integer.parseInt(tmp[1])]);
//			
//		}
//		
//		
//		dfs(vertices[1]);
//		
//		for (int j = 1; j < vertices.length; j++) {
//			System.out.print(vertices[j].valueOfSubtree+"  ");
//		}
//		System.out.println();
//		
//		System.out.println(checkDFS(vertices[1]));
//		
//
//		in.close();
//		out.close();
//	}
	
//}
