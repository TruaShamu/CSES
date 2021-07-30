import java.io.*;
import java.util.*;

public class cses2079 {
    public static int[] subSize;
    public static ArrayList<Integer>[] adj;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i=0; i< N; i++) {
            adj[i] = new ArrayList<>();
        }
        subSize = new int[N];

        /* Read edge */
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        subtreeSize(0, -1);
        System.out.println(getCentroid(0, -1) + 1);

    }

    public static int subtreeSize(int node, int par) {
        int res = 1;
        for (int next : adj[node]) {
            if (next == par) {
                continue;
            }
            res += subtreeSize(next, node);
        }
        return  (subSize[node] = res);

    }

    public static int getCentroid(int node, int par) {
        for (int next : adj[node]) {
            if (next == par) {
                continue;
            }

            if ((subSize[next] * 2) > N) {
                return getCentroid(next, node);
            }
        }
        return node;
    }
}
