import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class cses1639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
 
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
 
        dp[0][0] = 0;
 
        for (int i = 0; i <= arr1.length; i++) {
            for (int j = 0; j <= arr2.length; j++) {
                if (i != 0) {
                    dp[i][j] = Integer.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j != 0) {
                    dp[i][j] = Integer.min(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i != 0 && j != 0) {
                    int sum = dp[i - 1][j - 1];
                    if ((arr1[i - 1] != arr2[j - 1])) {
                        sum++;
                    }
                    dp[i][j] = Integer.min(dp[i][j], sum);
                }
            }
        }
 
        System.out.println(dp[arr1.length][arr2.length]);
 
 
    }
}
