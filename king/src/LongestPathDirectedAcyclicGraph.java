import java.util.ArrayList;

public class LongestPathDirectedAcyclicGraph {
	
	int vertices;
	ArrayList<Integer> edge[];
 
	LongestPathDirectedAcyclicGraph(int vertices) {
		this.vertices = vertices;
		edge = new ArrayList[vertices + 1];
		for (int i = 0; i <= vertices; i++) {
			edge[i] = new ArrayList<>();
		}
	}
 
	void addEdge(int a, int b) {
		edge[a].add(b);
	}
 
	void dfs(int node, ArrayList<Integer> adj[], int dp[], boolean visited[]) {
		// 标记访问过的结点
		visited[node] = true;
 
		// 遍历所有子节点
		for (int i = 0; i < adj[node].size(); i++) {
 
			// 如果没有访问过
			if (!visited[adj[node].get(i)])
				dfs(adj[node].get(i), adj, dp, visited);
 
			// 存储最长路径
			dp[node] = Math.max(dp[node], 1 + dp[adj[node].get(i)]);
		}
	}
 
	// 返回最长路径
	int findLongestPath(int n) {
		ArrayList<Integer> adj[] = edge;
		// 开辟DP数组
		int[] dp = new int[n + 1];
 
		//访问数组来确认之前的结点是否被访问过 
		boolean[] visited = new boolean[n + 1];
 
		// 对没有访问过的结点采用DFS算法
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				dfs(i, adj, dp, visited);
		}
 
		int ans = 0;
 
		// 遍历和寻找所有最大的dp[i]
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
 
	// Driver code
	public static void main(String[] args) {
		int n = 5;
		LongestPathDirectedAcyclicGraph graph = new LongestPathDirectedAcyclicGraph(n);
		// Example-1
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.findLongestPath(n);
		System.out.println(graph.findLongestPath(n));
 
	}
}