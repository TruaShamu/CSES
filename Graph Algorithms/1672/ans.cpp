#include <iostream>
using namespace std;

int main() {
    long mx = 1e18;
    int N, M, Q;
   cin >> N >> M >> Q;
   long d[N+1][N+1];
   for (int i=1; i<=N; i++) {
       for (int j=1; j<=N; j++) {
           d[i][j] = mx;
       }
       d[i][i] = 0;
   }
   for (int i=0; i< M; i++) {
        int a, b;
         long c;
        cin >> a >> b >> c;
        d[b][a] = d[a][b] = min(c, d[a][b]);
   }

    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || j == k) {
                    continue;
                }
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }

    for (int i = 0; i < Q; i++) {
            int a, b;
            cin >> a >> b;
            if (d[a][b] == mx) {
                cout << -1 << "\n";
            } else {
                cout << d[a][b] << "\n";
            }
        }
    }
