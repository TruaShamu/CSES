import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ans {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<edge>[] forward = new ArrayList[N];
        ArrayList<edge>[] backward = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            forward[a].add(new edge(b, c));
            backward[b].add(new edge(a, c));
        }

        long[] sourceDist = new long[N]; //DISTANCE FROM NODE1;
        Arrays.fill(sourceDist, Long.MAX_VALUE);
        sourceDist[0] = 0;


        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(0, 0));
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            for (edge next : forward[cur.node]) {
                if ((sourceDist[cur.node] + next.cost) < sourceDist[next.node]) {
                    sourceDist[next.node] = sourceDist[cur.node] + next.cost;
                    pq.add(new edge(next.node, sourceDist[next.node]));
                }
            }
        }
        //System.out.println("DIST FROM NODE 1 : " + Arrays.toString(sourceDist));

        long[] sinkDist = new long[N]; //DISTANCE FROM NODE N.
        Arrays.fill(sinkDist, Long.MAX_VALUE);
        sinkDist[N - 1] = 0;
        pq = new PriorityQueue<>();
        pq.add(new edge(N - 1, 0));

        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            for (edge next : backward[cur.node]) {
                if (sinkDist[cur.node] + next.cost < sinkDist[next.node]) {
                    sinkDist[next.node] = sinkDist[cur.node] + next.cost;
                    pq.add(new edge(next.node, sinkDist[next.node]));
                }

            }
        }

        //System.out.println("DIST FROM NODE N: " + Arrays.toString(sinkDist));

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (edge next : forward[i]) {
                ans = Long.min(ans, sourceDist[i] + sinkDist[next.node] + (next.cost / 2));
            }
        }
        System.out.println(ans);

    }

    static class edge implements Comparable<edge> {
        int node;
        long cost;

        public edge(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(edge other) {
            return Long.compare(this.cost, other.cost);
        }
    }


}
