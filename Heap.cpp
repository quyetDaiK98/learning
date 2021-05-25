#include<iostream>
using namespace std;


template <typename T>
class Heap{
	public:
		Heap(int capacity = 100){
			size = 0;
			this->capacity = capacity;
			array = new T[this->capacity];
		}
		~Heap(){
			delete[] array;
		}
		
		int getSize(){
			return size;
		}
		
		int getIndex(int index){
			return array[index];
		}
		
		void insert(T data){
			scaleCapacity();
			
			// Percolate Up (Tham thau nguoc)
			int holeIndex = size++;
			while(holeIndex != 0 && data < array[holeIndex/2]){
				array[holeIndex] = array[holeIndex/2];
				holeIndex /= 2;
			}
			array[holeIndex] = data;
		}
		
		void deleteMin(){
			if(size <= 1){
				size = 0;
				return;
			}
			
			// swap value from last element to root 
			array[0] = array[size - 1];
			size--;
			
			// Percolate Down (Tham thau xuoi)
			int holeIndex = 0;
			while(holeIndex * 2 <= (size - 1) && holeIndex * 2 + 1 <= (size - 1)){
				// node have 2 child and rightchild smaller than leftchild -> swap parent with its left child
				if (holeIndex * 2 + 1 <= (size - 1) && array[holeIndex * 2] > array[holeIndex * 2 + 1]) {
					swap(array[holeIndex], array[holeIndex * 2 + 1]);
					holeIndex = holeIndex * 2 + 1;
				}
				else {
					swap(array[holeIndex], array[holeIndex * 2]);
					holeIndex = holeIndex * 2;
				}
			}
			
			
		}
		
		
	private:
		T* array;
		int size;
		int capacity;
		void scaleCapacity(){
			if(size == capacity){
				capacity *= 2;
				T* old = array;
				array = new T[capacity];
				for(int i = 0; i < size; i ++)
					array[i] = old[i];
				delete[] old;
			}
		}		
		
		void swap(T &a, T &b){
			T temp = a;
			a = b;
			b = temp;
		}
};


int main(){
	Heap<int> heap;
	
	heap.insert(6);
	heap.insert(2);
	heap.insert(8);
	heap.insert(1);
	heap.insert(5);
	heap.insert(3);
	heap.insert(4);
	
	heap.deleteMin();
	
	for(int i = 0; i < heap.getSize(); i ++){
		cout << heap.getIndex(i);
	}

	
	system("pause");
	return 0;
}




