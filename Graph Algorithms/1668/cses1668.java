import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class cs1668v2 {
    static ArrayList[] edges;
    static int[] color;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n];
        //Initialize edges
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        //Read each edge
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            edges[i].add(j);
            edges[j].add(i);
        }
        color = new int[n];
        boolean works = true;
 
        for (int i = 0; i < n; i++)
            if (color[i] == 0 && !dfs(i, 1)) {
                works = false;
                break;
            }
        if (works) {
            for (int i = 0; i < n; i++) {
                pw.print(color[i] + " ");
            }
            pw.println();
        } else {
            pw.println("IMPOSSIBLE");
        }
        pw.close();
    }
 
    static boolean dfs(int i, int c) {
        if (color[i] != 0)
            return color[i] == c;
        color[i] = c;
        ArrayList<Integer> adj = edges[i];
        for (int j : adj) {
            if (!dfs(j, 3 - c)) {
                return false;
            }
        }
        return true;
    }
}
