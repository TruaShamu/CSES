import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class cses1666 {
    public static ArrayList<Integer>[] edges;
    public static int n, m;
    public static boolean[] visited;
    public static int[] rep;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n + 1];
        rep = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        int ans = countGroups();
        System.out.println(ans - 1);
        for (int i = 1; i < ans; ++i) {
            System.out.println(rep[i - 1] + " " + rep[i]);
        }
    }
 
 
    public static int countGroups() {
        int count = 0;
        for (int i = 1; i <= n; ++i)
            if (!visited[i]) {
                rep[count++] = i;
                dfs(i);
            }
        return count;
    }
 
    public static void dfs(int node) {
        visited[node] = true;
        for (int u : edges[node]) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }
}
 
