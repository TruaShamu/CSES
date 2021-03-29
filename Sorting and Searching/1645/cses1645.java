import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class cses1645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(1);
        int[] ans = new int[N + 1];
        ans[1] = 0;
        for (int i = 2; i <= N; i++) {
            //System.out.println("I: " + i);
            //System.out.println(stack);
            while (arr[stack.peek()] >= arr[i]) {
                //System.out.println("POP: " + stack.peek() + " " + arr[stack.peek()]);
                stack.pop();
                ///System.out.println(stack);
            }
 
 
            ans[i] = stack.peek();
            //System.out.println("ANS= " + ans[i]);
            stack.push(i);
            //System.out.println("_________________________");
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(ans[i] + " ");
        }
 
 
    }
}
