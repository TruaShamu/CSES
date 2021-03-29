import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class cses1745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //coins
 
        int maxSum = N * 1000;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        boolean[][] dp = new boolean[N + 1][maxSum + 1];
 
        dp[0][0] = true;
        for (int coin = 1; coin <= N; coin++) { //coins
            for (int sum = 0; sum <= maxSum; sum++) {
                int prev = coin - 1;
                dp[coin][sum] = dp[prev][sum];
                int remaining = sum - arr[prev];
                if (remaining >= 0 && dp[prev][remaining]) {
                    dp[coin][sum] = true;
                }
            }
        }
        ArrayList<Integer> possible = new ArrayList<>();
        for (int sum = 1; sum <= maxSum; sum++) {
            if (dp[N][sum]) {
                possible.add(sum);
            }
        }
        System.out.println(possible.size());
        for (int v : possible) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
