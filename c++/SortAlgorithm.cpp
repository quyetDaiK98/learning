#include<iostream>
#include<vector>
using namespace std;

// O(nLogn)
void quickSort(vector<int> & v){
	if(v.size() < 2)
		return;
	
	int pivotIndex = v.size()/2;
	int pivot = v[pivotIndex];
	vector<int> left;
	vector<int> right;
	
	for(int i = 0; i < v.size(); i++)
		if(v[i] < pivot)
			left.push_back(v[i]);
		else if(v[i] > pivot) 
			right.push_back(v[i]);
		
	quickSort(left);
	quickSort(right);
	
	v.clear();
	for(int i = 0; i < left.size(); i++)
		v.push_back(left[i]);
		
	v.push_back(pivot);	
	
	for(int i = 0; i < right.size(); i++)
		v.push_back(right[i]);
	
}

void merge(vector<int> left, vector<int> right, vector<int> & result){
	int l=0,r=0,i=0;
	
	// merge vao vector result cho den khi them het phan tu cua 1 trong 2 mang left or right
	while(l < left.size() && r < right.size())
		if(left[l] < right[r])
			result[i++] = left[l++];
		else 
			result[i++] = right[r++];
	
	// neu left con phan tu chua merge thi them not
	while(l < left.size())
		result[i++] = left[l++];
	
	// neu right con phan tu chua merge thi them not
	while(r < right.size())
		result[i++] = right[r++];
	

}

// O(nLogn)
void mergeSort(vector<int> & v){
	if(v.size() < 2)
		return;
	int mid = v.size() / 2;
	vector<int> left;
	vector<int> right;
	
	for(int i = 0; i < mid; i++)
		left.push_back(v[i]);
	
	
	for(int i = mid; i < v.size(); i++)
		right.push_back(v[i]);
	
	
	mergeSort(left);
	mergeSort(right);	
	merge(left, right, v);
}

// O(n^2)
void selectionSort(vector<int> & vector){
	for(int i = 0; i < vector.size() - 1; i++)
		for(int j = i + 1; j < vector.size(); j++)
			if(vector[j] < vector[i])
				swap(vector[i], vector[j]);
}

// O(n^2)
void bubbleSort(vector<int> & vector){
	for(int i = 0; i < vector.size() - 1; i++)
		for(int j = 0; j < vector.size() - 1 - i; j++)
			if(vector[j] > vector[j + 1])
				swap(vector[j], vector[j + 1]);
}

// O(n^2)
void insertionSort(vector<int> & vector){
	for(int i = 0; i < vector.size(); i++)
		for(int j = i; j > 0; j--)
			if(vector[j] < vector[j - 1])
				swap(vector[j], vector[j - 1]);
			else break;
}


void swap(int &a, int &b){
	int temp = a;
	a = b;
	b = a;
}

int main(){
	int myints[] = {25, 64, 12, 22, 11};
    vector<int> vector (myints, myints + sizeof(myints) / sizeof(int) );
    
    
//	selectionSort(vector);
//	bubbleSort(vector);
//	insertionSort(vector);
//	mergeSort(vector);
	quickSort(vector);
	
	for(int i = 0; i < vector.size(); i++)
		cout << vector[i] << " ";
	
	
	
	system("pause");
	return 0;
}









