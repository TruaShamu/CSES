import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class cses1194 {
    public static int[] dX = {1, -1, 0, 0};
    public static int[] dY = {0, 0, 1, -1};
    public static String dirs = "DURL";
    public static int N, M;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
 
        int[][] dist = new int[N][M]; //Distance grid for monsters.
        boolean[][] visited = new boolean[N][M]; //Visited grid for monsters.
 
        Queue<point> q = new LinkedList<>();
        //Process the grid.
        point start = new point(-1, -1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //Add each monster to the queue.
                if (grid[i][j] == 'M') {
                    q.add(new point(i, j));
                    dist[i][j] = 0;
                    visited[i][j] = true;
                }
                if (grid[i][j] == 'A') {
                    start = new point(i, j);
                }
            }
        }
 
        //Run a BFS for the monsters.
        while (!q.isEmpty()) {
            point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                //The next location.
                int x1 = x + dX[i];
                int y1 = y + dY[i];
                if (onGrid(x1, y1) && !visited[x1][y1] && grid[x1][y1] != '#') {
                    //Mark the location as visited.
                    visited[x1][y1] = true;
                    dist[x1][y1] = dist[x][y] + 1;
                    q.add(new point(x1, y1));
                }
            }
        }
 
        //Initialize for human BFS.
        q = new LinkedList<>();
        q.add(new point(start.x, start.y));
        int[][] dist1 = new int[N][M]; //Distance grid for the human.
        dist1[start.x][start.y] = 0;
 
        boolean[][] visited1 = new boolean[N][M]; //Visited grid for the human.
        visited1[start.x][start.y] = true;
 
        //step[i][j] is the step direction that we take to reach point (i, j).
        char[][] step = new char[N][M];
        //prevLoc[i][j] is the previous point before reaching point (i, j).
        point[][] prevLoc = new point[N][M];
        prevLoc[start.x][start.y] = new point(-1, -1);
 
        //Run a BFS for the human.
        while (!q.isEmpty()) {
            point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                //The next location.
                int x1 = x + dX[i];
                int y1 = y + dY[i];
                char d = dirs.charAt(i);
 
                //Reached a boundary square.
                if (!onGrid(x1, y1)) {
                    System.out.println("YES");
                    System.out.println(dist1[x][y]);
                    StringBuilder ans = new StringBuilder();
                    //Go backwards to print all the steps.
                    while (x != -1) {
                        if (prevLoc[x][y].x != -1) {
                            ans.append(step[x][y]);
                        }
                        int tmp = x;
                        x = prevLoc[x][y].x;
                        y = prevLoc[tmp][y].y;
                    }
                    System.out.println(ans.reverse());
                    return;
                }
 
                if (!visited1[x1][y1] && grid[x1][y1] != '#') {
                    if (visited[x1][y1] && (dist[x1][y1] <= dist1[x][y] + 1)) {
                        continue;
                    }
                    //Mark the location as visited.
                    visited1[x1][y1] = true;
                    dist1[x1][y1] = dist1[x][y] + 1;
                    q.add(new point(x1, y1));
                    prevLoc[x1][y1] = new point(x, y);
                    step[x1][y1] = d;
                }
            }
        }
 
        System.out.println("NO");
 
    }
 
    //Whether or not the point is on the grid.
    public static boolean onGrid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
 
    public static class point {
        public int x, y;
 
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
}
