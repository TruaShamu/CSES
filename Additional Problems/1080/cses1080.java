import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class cses1080 {
 
    public static int MAXN = 505;
    public static int MOD = (int) 1e9 + 7;
 
    public static long[][] dp = new long[MAXN][MAXN];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        //@todo read input
        String inp = br.readLine();
        int N = inp.length();
        char[] s = new char[N + 1];
        for (int i = 1; i <= N; i++) {
            s[i] = inp.charAt(i - 1);
        }
 
 
        long[][] C = new long[N + 1][N + 1];
 
        for (int i = 0; i <= N; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
        }
 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
 
        //Base Case
        for (int i = 1; i <= N + 1; i++) {
            dp[i][i - 1] = 1;
        }
 
 
        for (int len = 1; len < N; len += 2) {
            for (int l = 1; l <= (N - len) ; l++) {
                int r = l + len;
 
                for (int i = l + 1; i <= l + len; i += 2) {
 
                    if (s[l] == s[i]) {
 
                        if (i == N) {
                            dp[l][r] += dp[l + 1][i - 1] * C[(len + 1) / 2][(i - l + 1) / 2] % MOD;
                            dp[l][r] %= MOD;
 
                        } else {
 
                            dp[l][r] += (dp[i + 1][r] * dp[l + 1][i - 1] % MOD * C[(len + 1) / 2][(i - l + 1) / 2]) % MOD;
                            dp[l][r] %= MOD;
                        }
                    }
                }
            }
        }
        System.out.println(dp[1][N]);
 
    }
}
