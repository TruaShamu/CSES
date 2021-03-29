import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cses1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] moves = new int[W + 1][H + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= H; j++) {
                if (i == j) {
                    moves[i][j] = 0;
                    continue;
                }
                moves[i][j] = (int) 1e9 + 7;
 
                //Cut it along the width
                for (int wCut = 1; wCut < i; wCut++) {
                    moves[i][j] = Integer.min(moves[i][j], moves[wCut][j] + moves[i - wCut][j] + 1);
                }
                for (int hCut = 1; hCut < j; hCut++) {
                    moves[i][j] = Integer.min(moves[i][j], moves[i][hCut] + moves[i][j - hCut] + 1);
                }
            }
        }
        System.out.println(moves[W][H]);
        
 
    }
}
