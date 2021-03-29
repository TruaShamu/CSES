import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] costs = new int[N];
        //Read costs
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] pages = new int[N];
        //Read pages
        for (int i = 0; i < N; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }
 
        int[][] dp = new int[N + 2][X + 2];
 
        for (int book = 1; book <= N; book++) {
            for (int amt = 0; amt <= X; amt++) {
                dp[book][amt] = dp[book - 1][amt];
                int lower = amt - costs[book - 1];
                if (lower >= 0) {
                    dp[book][amt] = Integer.max(dp[book][amt], dp[book - 1][lower] + pages[book - 1]);
                }
            }
        }
 
        //System.out.println("ANSWER: ");
        System.out.println(dp[N][X]);
        //System.out.println("-----------------------");
    }
}
