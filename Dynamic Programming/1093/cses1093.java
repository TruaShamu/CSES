import java.io.*;
import java.util.*;


public class cses1093 {
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        // The total sum of all N elements.
        long totalSum = (long) (N * (N + 1)) / 2;

        //This cannot be partitioned into 2 equal subsets.
        if (totalSum % 2 != 0) {
            System.out.println(0);
            System.exit(0);
        }
        totalSum /= 2;

        /*
         * DP[i][j] is the number of ways to make sum j with the first i elements.
         * The range of 'idx' is from 0 to N-1 because if all elements are used,
         * the subsets will be double counted.
         */
        long[][] dp = new long[N][(int) totalSum + 1];
        dp[0][0] = 1;
        for (int idx = 0; idx < N; idx++) {
            for (int curSum = 0; curSum <= totalSum; curSum++) {
                /*
		         * If the state (curSum - current element) is possible
		         * DP[curSum] += DP[current element - 1][curSum - current element]
                 */
                if (idx >= 1) {
                    dp[idx][curSum] = dp[idx - 1][curSum];
                    int prev = curSum - idx;
                    if (prev >= 0) {
                        dp[idx][curSum] += dp[idx - 1][prev];
                        dp[idx][curSum] %= MOD;
                    }
                }
            }
        }
       io.println(dp[N - 1][(int) totalSum]);
       io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in,System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName+".out"));
            r = new BufferedReader(new FileReader(problemName+".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
