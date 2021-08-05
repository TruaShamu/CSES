#include <bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int N, a, b;
	cin >> N >> a >> b;

	vector<long long> prefixSum(N + 1);
	for (int i = 1; i <= N; i++) {
		int inp; cin >> inp;
		prefixSum[i] = inp + prefixSum[i - 1]; 
	}

	long long ret = -1e18;
	multiset<long long> set;

	for (int i = a; i <= N; i++) {
		if (i > b) {
			set.erase(set.find(prefixSum[i - b - 1]));
		}
		set.insert(prefixSum[i - a]);
		ret = max(ret, prefixSum[i] - *set.begin());
	}

	cout << ret << "\n";
}
