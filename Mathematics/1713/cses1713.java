import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class cses1713 {
    public static int MAXN = 1000000;
    public static int[] maxDiv = new int[MAXN + 1];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 2; i <= MAXN; i++) {
            if (maxDiv[i] == 0) {
                for (int j = i; j <= MAXN; j += i) {
                    maxDiv[j] = i;
                }
            }
        }
 
 
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int ans = 1;
 
            while (x != 1) {
                int prime = maxDiv[x];
                int count = 0;
                while (x % prime == 0) {
                    count++;
                    x = x / prime;
                }
                ans = ans * (count + 1);
            }
            System.out.println(ans);
        }
 
 
    }
 
 
}
