#include <iostream>

using namespace std;

int main(){
	int n;
	cout << "nhap n:";cin >> n;
	int mang[n];
	cout << "nhap mang A" << endl;
	for(int i = 0; i < n ; i ++){
		cout << "A[" << i << "]=";cin >> mang[i];
	}
	
	// tim max
	int max = mang[0];
	for(int i = 0; i < n; i++){
		if(mang[i] > max){
			max = mang[i];
		}
	}
	
	int countMax=0;
	for(int i = 0; i < n ; i ++)
		if(mang[i] == max)
			countMax++;
	
	int ret[n-countMax];
	int j=0;
	for(int i = 0; i < n ; i ++){
		if(mang[i] != max){
			ret[j] = mang[i];
			j++;
		}
			
	}
		
	for(int i = 0; i < n-countMax ; i ++){
		cout << ret[i] << " ";
	}
	
	system("pause");
	return 0;
}

