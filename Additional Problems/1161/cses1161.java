import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class cses1161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long inp = Long.parseLong(st.nextToken());
            pq.add(inp);
        }
 
        long sum = 0;
        while (pq.size() > 1) {
            long k = pq.poll();
            k += pq.poll();
            sum += k;
            pq.add(k);
        }
        System.out.println(sum);
 
 
    }
}
