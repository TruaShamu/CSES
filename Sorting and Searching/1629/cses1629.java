import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cses1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            points[i] = new Point(s, e);
        }
        Arrays.sort(points);
        for (Point oPoint : points) {
            //System.out.println(oPoint.s + " " + oPoint.e);
        }
 
        long lastEnd = -1;
        int ans = 0;
        for (Point oPoint : points) {
            if (oPoint.s >= lastEnd) {
                lastEnd = oPoint.e;
                ans++;
            } else {
                continue;
            }
        }
        System.out.println(ans);
 
    }
}
 
class Point implements Comparable<Point> {
    public long s, e;
 
    public Point(long s, long e) {
        this.s = s;
        this.e = e;
    }
 
    public int compareTo(Point other) {
        if (this.e != other.e) {
            return Long.compare(this.e, other.e);
        } else {
            return Long.compare(other.s, this.s);
        }
    }
}
