#include <bits/stdc++.h>
using namespace std;


int main() {
	int A[200005];
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}

	int r = -1;
	int ret = 0;
	set<int> set;
	for (int i = 0; i < N; i++) {
		while (r < N - 1 && !set.count(A[r + 1])) {
			set.insert(A[++r]);
		}
		ret = max(ret, r - i + 1);
		set.erase(A[i]);
	}

	cout << ret;
}
