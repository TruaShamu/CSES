import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cses1633 {
    public static int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                    dp[i] %= MOD;
                }
            }
        }

        System.out.println(dp[N]);


    }
}
