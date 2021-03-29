import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cses1635 {
    public static int MOD = (int) 1e9 + 7;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
 
        Arrays.sort(coins);
 
        int[] dp = new int[x + 1];
        dp[0] = 1;
 
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < N; j++) {
                if (coins[j] > i) {
                    break;
                }
                dp[i] += dp[i - coins[j]];
 
                if (dp[i] > MOD) {
                    dp[i] -= MOD;
                }
            }
        }
 
        System.out.println(dp[x]);
        System.out.close();
 
 
    }
}
