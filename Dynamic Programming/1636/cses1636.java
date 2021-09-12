import java.io.*;
import java.util.*;
public class cses1636 {
    public static int MAX = (int) 1e6 + 5;
    public static final int MOD = (int) 1e9 + 7;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
 
        int[] dp = new int[MAX];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int weight = 0; weight <= X; weight++) {
                if(weight - coins[i - 1] >= 0) {
                    dp[weight] += dp[weight - coins[i - 1]];
                    dp[weight] %= MOD;
                }
            }
        }
 
        System.out.println(dp[X]);
    }
}
