import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class cses1637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        Arrays.fill(arr, (int) 1e9 + 7);
        arr[0] = 0;
        for (int num = 0; num <= N; num++) {
            String toStr = Integer.toString(num);
            for (int idx = 0; idx < toStr.length(); idx++) {
                char oChar = toStr.charAt(idx);
                int subtract = oChar - '0';
                arr[num] = Integer.min(arr[num], arr[num - subtract] + 1);
            }
        }
        System.out.println(arr[N]);
    }
}
