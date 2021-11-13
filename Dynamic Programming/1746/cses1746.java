import java.io.*;
import java.util.*;
 
public class ArrayDesc {
	public static final int MOD = (int) 1e9 + 7;
	public static void main(String args[]) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		// DP[i][j] is the number of ways
		// to make a valid array from 0 to i, if the ith value is j.
		int[][] dp = new int[N][M + 1];
 
		// Process the first element in the array.
		StringTokenizer arr = new StringTokenizer(r.readLine());
		int first = Integer.parseInt(arr.nextToken());
		// The first element can be anything.
		if (first == 0) {
			Arrays.fill(dp[0], 1);
		} else {
			// This is the only valid value.
			dp[0][first] = 1;
		}
 
		for (int i = 1; i < N; i++) {
			int A = Integer.parseInt(arr.nextToken());
			// A free element.
			if (A == 0) {
				for (int j = 1; j <= M; j++) {
					int[] neighborVals = new int[] {j - 1, j, j + 1};
					for (int k : neighborVals) {
						// Number of values,
						// where the previous value is in the valid range.
						if (1 <= k && k <= M) {
							dp[i][j] += dp[i - 1][k];
							dp[i][j] %= MOD;
						}
					}
				}
			} else {
				// Find number of ways that the current value is valid.
				int[] neighborVals = new int[] {A - 1, A, A + 1};
				for (int k : neighborVals) {
					if (1 <= k && k <= M) {
						dp[i][A] += dp[i - 1][k];
						dp[i][A] %= MOD;
					}
				}
			}
		}
 
		//Aggregate the dp values.
		int ans = 0;
		for (int j = 1; j <= M; j++) {
			ans += dp[N - 1][j];
			ans %= MOD;
		}
		System.out.println(ans);
	}
}
