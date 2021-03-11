import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cses1196 {
    public static ArrayList<edge>[] adj;

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int N = fs.nextInt();
        int M = fs.nextInt();
        int K = fs.nextInt();

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {

            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            int c = fs.nextInt();
            adj[a].add(new edge(b, c));
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(0, 0));

        ArrayList<Long>[] ans = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ans[i] = new ArrayList<>();
        }


        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (ans[cur.node].size() == K) {
                continue;
            }
            ans[cur.node].add(cur.weight);
            for (edge next : adj[cur.node]) {
                pq.add(new edge(next.node, cur.weight + next.weight));
            }
        }

        for (int i = 0; i < K; i++) {
            System.out.print(ans[N - 1].get(i) + " ");
        }


    }


    static class edge implements Comparable<edge> {
        int node;
        long weight;

        public edge(int node, long weight) {
            this.node = node;
            this.weight = weight;

        }

        public int compareTo(edge other) {
            return Long.compare(this.weight, other.weight);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
