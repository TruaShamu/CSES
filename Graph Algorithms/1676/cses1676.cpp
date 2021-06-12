#include <bits/stdc++.h>
using namespace std;

int disjoint[100005];

int find(int node) {
    if (disjoint[node] < 0) {
        return node;
    }
    else {
        return disjoint[node] = find(disjoint[node]);
    }
}

int main() {
    memset(disjoint, -1, sizeof(disjoint));
    
    int N, M;
    cin >> N >> M;
    int mx = 1;
    int cnt = N;

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        a = find(a);
        b = find(b);
        if (a != b) {
            disjoint[a] += disjoint[b];
            mx = max(mx, -disjoint[a]);
            disjoint[b] = a;
            cnt--;
        }
    }

    cout << cnt << " " << mx << "\n";

}
