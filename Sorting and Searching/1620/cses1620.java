import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long low = 0;
        long high = (long) 1e18;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / arr[i]);
                if (sum >= t) { //deal with overflow
                    break;
                }
            }
 
            if (sum >= t) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
 
        System.out.println(ans);
    }
}
