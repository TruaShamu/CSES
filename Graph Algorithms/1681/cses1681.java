import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class cses1681 {
    public static int mod = (int) 1e9 + 7;
    public static ArrayList<Integer>[] forwards;
    public static ArrayList<Integer>[] backwards;
    public static int[] degree, dp;
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        forwards = new ArrayList[N];
        backwards = new ArrayList[N];
        degree = new int[N];
        dp = new int[N];
        //Initialize the adjacency lists
        for (int i = 0; i < N; i++) {
            forwards[i] = new ArrayList<>();
            backwards[i] = new ArrayList<>();
        }
 
        dp[0] = 1;
        //Read in each edge.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            forwards[a].add(b);
            backwards[b].add(a);
            degree[b]++; //The degree of the node in the topological sort.
        }
        //System.out.println(Arrays.toString(degree));
 
        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < N; node++) {
            //An source node (edges flow out of the node but there are no edges that flow in this node).
            if (degree[node] == 0) {
                queue.add(node);
            }
        }
 
        while (!queue.isEmpty()) {
            int cur = queue.poll();
 
            //Remove the current node, then check which nodes are now sources and add it to the queue.
            for (int next : forwards[cur]) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
 
            //Calculate the number of ways.
            for (int prev : backwards[cur]) {
                dp[cur] = (dp[cur] + dp[prev]) % mod;
            }
        }
 
 
        //Print the answers.
       // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N - 1]);
 
    }
}
