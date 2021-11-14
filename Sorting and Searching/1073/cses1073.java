import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class cses1073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        ArrayList<Integer> dp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
 
            int lo = 0;
            int hi = dp.size();
            while (lo < hi) {
                int mid = (lo+hi)/2;
                if (dp.get(mid) > x) hi = mid;
                else lo = mid+1;
            }
 
            if (lo == dp.size()) {
                dp.add(x);
            } else {
                dp.set(lo, x);
            }
        }
 
        System.out.println(dp.size());
    }
}
