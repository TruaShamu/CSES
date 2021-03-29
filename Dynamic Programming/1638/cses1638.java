import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class cses1638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] ok = new boolean[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            String inp = br.readLine();
            for (int j = 0; j < inp.length(); j++) {
                if (inp.charAt(j) == '.') {
                    ok[i][j] = true;
                } else {
                    ok[i][j] = false;
                }
 
            }
        }
 
 
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!ok[i][j]) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
 
        System.out.println(dp[N - 1][N - 1]);
    }
}
