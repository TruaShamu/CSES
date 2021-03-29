import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class cses1712 {
    public static long mod = (long) 1000000007;
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            long x = pow(b, c, mod - 1);
            System.out.println(pow(a, x, mod));
 
        }
 
 
    }
 
    public static long pow(long a, long b, long m) {
        long r = 1, e = a;
        while (b > 0) {
            if ((b & 1) > 0) {
                r *= e;
                r %= m;
            }
            e *= e;
            e %= m;
            b >>= 1;
        }
        return r;
    }
}
