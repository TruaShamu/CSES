import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class cses1682 {
    public static ArrayList<Integer>[][] adj;
    public static boolean[] vis;
    public static Stack<Integer> stack = new Stack<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N][2];
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a][0].add(b);
            adj[b][1].add(a);
        }
 
        dfs(0, 0);
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                System.out.println("NO");
                System.out.println(1 + " " + (i + 1));
                System.exit(0);
            }
        }
 
        Arrays.fill(vis, false);
        dfs(0, 1);
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                System.out.println("NO");
                System.out.println((i + 1) + " " + 1);
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
 
    public static void dfs(int node, int dir) {
        vis[node] = true;
        for (int next : adj[node][dir]) {
            if (!vis[next]) {
                dfs(next, dir);
            }
        }
    }
 
 
}
 
