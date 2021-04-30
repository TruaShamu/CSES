import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cses1653 {
    public static int N, X;
    public static int[] W;
    public static pair[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        W = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        dp = new pair[1 << N];

        dp[0] = new pair(1, 0);

        for (int mask = 1; mask < (1 << N); mask++) {
            dp[mask] = new pair((N + 2), (X + 2));
            for (int i = 0; i < N; i++) {
                if (((mask >> i) & 1) > 0) {
                    int xorInd = mask ^ (1 << i);
                    pair oPair = new pair(dp[xorInd].rides, dp[xorInd].weight);
                    if (oPair.weight + W[N - 1 - i] > X) {
                        oPair.rides++;
                        oPair.weight = Integer.min(W[N - 1 - i], oPair.weight);
                    } else {
                        oPair.weight += W[N - 1 - i];
                    }
                    if (oPair.compareTo(dp[mask]) < 0) {
                        dp[mask] = oPair;
                    }
                }
            }
        }

        System.out.println(dp[(1 << N) - 1].rides);

    }

    static class pair {
        public int rides, weight;

        public pair(int rides, int weight) {
            this.rides = rides;
            this.weight = weight;
        }

        public int compareTo(pair oPair) {
            if (this.rides == oPair.rides) {
                return Integer.compare(this.weight, oPair.weight);
            }
            return Integer.compare(this.rides, oPair.rides);
        }
    }
}
