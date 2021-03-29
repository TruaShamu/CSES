import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1085 {
    public static long[] arr;
    public static int n, k;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
 
        long l = 0;
        for (long i = sum / 2; i >= 1; i /= 2) {
            while (l + i < sum && !valid(l + i)) {
                l += i;
            }
        }
        System.out.println(l + 1);
    }
 
    public static boolean valid(long sum) {
        long s = 0;
        int i = 1; //nUMBER OF SUBARRAYS
        for (long x : arr) {
            if (x > sum) {
                return false;
            }
            if (s + x > sum) {
                s = x;
                i++;
            } else {
                s += x;
            }
        }
        return (i <= k);
 
    }
 
 
}
