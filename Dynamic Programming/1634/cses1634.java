import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1634 {
    public static int MAX = (int) 10e6 + 3;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
 
        int[] coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
 
        int[] dp = new int[x + 1];
        for (int i = 0; i <= x; i++) {
            dp[i] = MAX;
        }
 
        dp[0] = 0;
 
        for (int i = 1; i <= N; i++) {
            for (int sum = 0; sum <= x; sum++) {
                if (sum - coins[i - 1] >= 0) {
                    dp[sum] = Integer.min(dp[sum], dp[sum - coins[i - 1]] + 1);
                }
            }
        }
 
        if (dp[x] == MAX) {
            System.out.println(-1);
            System.exit(0);
        }
 
        System.out.println(dp[x]);
 
 
    }
}
