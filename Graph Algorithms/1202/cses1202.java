import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class cses1202v2 {
    public static long mod = (long) 1e9 + 7;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
 
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
 
        //@todo READ EDGES
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long cost = Long.parseLong(st.nextToken());
            adj.get(a).add(new Edge(a, b, cost));
        }
 
 
        long[] costs = new long[N];
        Arrays.fill(costs, Long.MAX_VALUE);
        costs[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        long[] numWays = new long[N];
        long[] minF = new long[N];
        long[] maxF = new long[N];
        Arrays.fill(minF, Long.MAX_VALUE);
        minF[0] = 0;
        maxF[0] = 0;
        numWays[0] = 1;
 
 
        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            for (Edge next : adj.get(cur.node)) {
 
 
                if (costs[next.b] == cur.cost + next.cost) {
                    numWays[next.b] += numWays[cur.node];
                    numWays[next.b] %= mod;
                    minF[next.b] = Math.min(minF[next.b], minF[cur.node] + 1);
                    maxF[next.b] = Math.max(maxF[next.b], maxF[cur.node] + 1);
 
 
                } else if (costs[next.b] > cur.cost + next.cost) {
                    costs[next.b] = cur.cost + next.cost;
                    pq.add(new Node(next.b, costs[next.b]));
                    numWays[next.b] = numWays[cur.node];
                    minF[next.b] = minF[cur.node] + 1;
                    maxF[next.b] = maxF[cur.node] + 1;
                }
            }
        }
 
        //ANSWER.
        System.out.println(costs[N - 1] + " " + numWays[N - 1] + " " + minF[N - 1] + " " + maxF[N - 1]);
 
 
    }
 
    public static class Node implements Comparable<Node> {
        int node;
        long cost;
 
        public Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
 
        public int compareTo(Node other) {
            if (this.cost <= other.cost) {
                return -1;
            }
            return 1;
        }
    }
 
    public static class Edge {
        int a;
        int b;
        long cost;
 
        public Edge(int a, int b, long cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
