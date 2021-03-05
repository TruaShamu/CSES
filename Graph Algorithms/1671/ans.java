import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
 
public class cses1671 {
 
    public static long[] dist;
    public static ArrayList<Edge>[] edges;
 
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Reader sc = new Reader();
        int N = sc.nextInt();
        int M = sc.nextInt();
 
 
        dist = new long[N];
        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
 
 
        for (int i = 0; i < M; i++) {
 
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            edges[a].add(new Edge(c, b));
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        djikstra(0);
        for (int i = 0; i < N - 1; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println(dist[N - 1]);
 
    }
 
 
    public static void djikstra(int source) {
        dist[source] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, source));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.weight > dist[cur.node]) {
                continue;
            }
 
            for (Edge next : edges[cur.node]) {
                if ((dist[next.node] > dist[cur.node] + next.weight)) {
                    dist[next.node] = dist[cur.node] + next.weight;
                    pq.add(new Edge(dist[next.node], next.node));
                }
            }
 
        }
 
    }
 
 
    public static class Edge implements Comparable<Edge> {
        public long weight;
        public int node;
 
        public Edge(long weight, int node) {
            this.weight = weight;
            this.node = node;
        }
 
        public int compareTo(Edge other) {
            return Long.compare(this.weight, other.weight);
        }
    }
 
}
 
class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, Integer.max(cnt - 1, 0));
    }
 
    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
 
        if (neg)
            return -ret;
        return ret;
    }
 
    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }
 
    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
 
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
 
    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}
