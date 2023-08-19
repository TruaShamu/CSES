import java.io.*;
import java.util.*;
 
public class cses1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
 
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i : A) {
 
            int pos = lower_bound(lis, i);
            if (pos == lis.size()) {
                lis.add(i);
            } else {
                lis.set(pos, i);
            }
        }
        System.out.println(lis.size());
    }
 
    public static int lower_bound(ArrayList<Integer> arr, int key) {
        int N = arr.size();
        if (N == 0) {
            return 0;
        }
        int lo = 0;
        int hi = N - 1;
        int mid = (lo + hi) / 2;
        while (true) {
            int i = arr.get(mid);
            int cmp = arr.get(mid).compareTo(key);
            if (cmp == 0 || cmp > 0) {
                hi = mid - 1;
                if (hi < lo) {
                    return mid;
                }
            } else {
                lo = mid + 1;
                if (hi < lo) {
                    return (mid < N - 1) ? (mid + 1) : N;
                }
            }
            mid = (lo + hi) / 2;
        }
    }
}
 
