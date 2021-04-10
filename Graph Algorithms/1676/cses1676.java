import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cses1676 {
	public static int[] disjoint;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//Initialize.
		disjoint = new int[N];
		Arrays.fill(disjoint, -1);
		//The size of the largest connected component.
		int largestCC = 1; 

		//Read in the connections.
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int newSize = union(a, b);
			if (newSize != 0) {
				N--;
				//Check which connected component is larger.
				largestCC = Integer.max(largestCC, newSize);
			}
			pw.println(N + " " + largestCC);
		}
		pw.close();
	}

	/*Disjoint Set Union */

	//Find the ancestor.
	public static int find(int v) {
		if (disjoint[v] < 0) {
			return v;
		}
		disjoint[v] = find(disjoint[v]);
		return disjoint[v];
	}

	public static int union(int u, int v) {
		//Find the ancestor of both nodes
		u = find(u);
		v = find(v);

		//They are in the same connected component.
		if (u == v) {
			return 0;
		}

		if (disjoint[u] < disjoint[v]) {
			int tempU = u;
			u = v;
			v = tempU;
		}
		disjoint[v] += disjoint[u]; //Append u's children to v.
		disjoint[u] = v; // Set v as u's parent.
		return -disjoint[v];
	}

}
