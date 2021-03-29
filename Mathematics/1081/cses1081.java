import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1095 {
    public static int MAX = 1000000;
    public static int[] cnt = new int[MAX + 1];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }
 
        
        for (int i = MAX; i > 0; i--) {
 
            int div = 0;
            for (int j = i; j <= MAX; j += i) {
                //System.out.println("i: " + i + " j: " + j);
                div += cnt[j];
            }
            if (div > 1) {
                System.out.println(i);
                System.exit(0);
            }
        }
 
 
    }
}
