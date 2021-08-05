#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	vector<long long> A(N);
	long long sum = 0;
	A[sum] = 1;
	for (int i = 0; i < N; i++) {
		int inp;
		cin >> inp;
		sum += inp;
		A[(sum % N + N) % N]++;
	}

	long long ans = 0;
	for (long long i : A) {
		ans += i * (i - 1) / 2;
	}
	cout << ans << endl;
}
