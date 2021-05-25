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
	
	// dem so lan xuat hien max
	int countMax=0;
	for(int i = 0; i < n ; i ++)
		if(mang[i] == max)
			countMax++;
	
	// tao mang moi roi them cac phan tu khong phai max
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

