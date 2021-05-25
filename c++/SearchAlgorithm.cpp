#include<iostream>
#include<vector>
using namespace std;

int binarySearch(int a, vector<int> v) {
	if (v.size() < 1)
		return -1;

	int midIndex = v.size() / 2;
	int mid = v[midIndex];

	if (a < mid) {
		vector<int> left;
		for (int i = 0; i < midIndex; i++)
			left.push_back(v[i]);
		return binarySearch(a, left);
	}
	else if (a > mid) {
		vector<int> right;
		for (int i = midIndex + 1; i < v.size(); i++)
			right.push_back(v[i]);
		return binarySearch(a, right);
	}
	else return mid;



}

int main() {
	int myints[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	vector<int> v(myints, myints + sizeof(myints) / sizeof(int));
	cout << binarySearch(6, v);

	system("pause");
	return 0;
}
