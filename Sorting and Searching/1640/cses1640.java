import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cses1640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            int inp = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(inp, i);
        }
 
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (j > i) {
            int k = (arr[i].a) + (arr[j].a);
            if (k == x) {
                System.out.println(((arr[i].b) + 1) + " " + ((arr[j].b) + 1));
                System.exit(0);
            }
            if (k < x) {
                i++;
            } else j--;
        }
 
        System.out.println("IMPOSSIBLE");
    }
}
 
class Pair implements Comparable<Pair> {
    public int a, b;
 
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
 
    public int compareTo(Pair oPair) {
        if (this.a != oPair.a) {
            return Integer.compare(this.a, oPair.a);
        }
        return Integer.compare(this.b, oPair.b);
    }
 
 
}
