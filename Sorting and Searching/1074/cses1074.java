import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cses1074 {
    public static int N;
    public static long[] arr;
 
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("test_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long median = arr[N / 2];
        long s = 0;
        for (int i = 0; i < N; i++) {
            s += Math.abs(arr[i] - median);
        }
 
        System.out.println(s);
 
    }
 
 
}
