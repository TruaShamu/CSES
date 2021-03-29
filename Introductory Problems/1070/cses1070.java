import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long layer = Long.max(r, c);
            long ans;
            long cell = (layer - 1) * (layer - 1);
 
            //Layer starts from top
            if (layer % 2 == 0) {
 
                if (layer == c) {
                    ans = cell + r;
                } else {
                    ans = cell + 2 * layer - c;
                }
            } else {
                //Layer starts from bottom
                if (layer == r) {
                    ans = cell + c;
                } else {
                    ans = cell + 2 * layer - r;
                }
 
            }
 
            System.out.println(ans);
 
        }
    }
}
