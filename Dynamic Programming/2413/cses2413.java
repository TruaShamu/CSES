import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cses2413 {

    public static int MAX = (int) 1e6 + 5;
    public static long[][] dp = new long[MAX][3];
    public static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i < MAX; i++) {
            dp[i][1] = (dp[i - 1][1] * 4 % MOD + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][2] * 2 % MOD) % MOD;
        }



        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2]) % MOD);
        }

    }


}
