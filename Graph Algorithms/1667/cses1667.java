import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cses1667 {
    public static ArrayDeque<Integer>[] adj;
    public static int[] dist;
    public static int[] par;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N];
        par = new int[N];
        adj = new ArrayDeque[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        int ans = BFS(0, N - 1);
        if (ans == -1) {
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }
        System.out.println(ans);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(N);
        int node = N - 1;
        while (node != 0) {
            node = par[node];
            answer.add((node + 1));
        }
        Collections.reverse(answer);
        for (int i = 0; i < answer.size() - 1; i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println(answer.get(answer.size() - 1));
    }

    public static int BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 1;
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            //Terminate
            if (cur == end) {
                return dist[cur];
            }
            //Visit neighbors
            for (int next : adj[cur]) {
                if (dist[next] != 0) {
                    continue;
                }
                dist[next] = dist[cur] + 1;
                par[next] = cur; // Track the route.
                q.add(next);
            }
        }
        return -1;


    }
}
