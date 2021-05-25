#include<iostream>
using namespace std;

template <typename T>
class QueueArray{
	public:
		QueueArray(int capacity = 100){
			front = 0;
			back = 0;
			this->capacity = capacity;
			array = new T[capacity];
			size = 0;
		}
		
		~QueueArray(){
			delete[] array;
		}
		
		bool isEmpty(){
			return (size == 0);
		}
		
		int getSize(){
			return size;
		}
		
		void enqueue(T t){
			array[back] = t;
			back = (back % capacity) + 1;
			size++;
		}
		
		T dequeue(){
			int index = front;
			front = (front % capacity) + 1;
			size--;
			return array[index];
		}
		
	private:
		T *array;
		int front;
		int back;
		int size;	
		int capacity;
};

int main(){
	QueueArray<char> s;
	
	if (s.isEmpty())
		cout << "Hang doi dang rong" << endl;
	
	s.enqueue('B'); 
	s.enqueue('E');
	s.enqueue('K');
	s.enqueue('A');
	s.enqueue('C');
	
	s.dequeue();
	s.dequeue();
	s.dequeue();
	cout << s.getSize() << endl;
	cout << s.dequeue() << endl;
	
	system("pause");
	return 0;
}
