import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        long sum = 0;
        for (int v : arr) {
            sum += v;
        }
 
        long[][] dp = new long[N][N];
 
        for (int l = N - 1; l >= 0; l--) {
            for (int r = l; r < N; r++) {
                if (l == r) {
                    dp[l][r] = arr[l];
                } else {
                    dp[l][r] = Long.max(arr[l] - dp[l + 1][r], arr[r] - dp[l][r - 1]);
                }
            }
        }
 
        System.out.println((sum + dp[0][N - 1]) / 2);
    }
}
