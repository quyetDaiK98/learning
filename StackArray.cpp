#include<iostream>
using namespace std;

template <typename T>
class StackArray{
	public:
		StackArray(int capacity = 100){
			top = -1;
			array = new T[100];
		}
		
		~StackArray(){
			delete[] array;
		}
		
		bool isEmpty(){
			return (top == -1);
		}
		
		int getSize(){
			return (top + 1);
		}
		
		void push(T t){
			array[++top] = t;
		}
		
		void pop(){
			top--;
		}
		
		T getTop(){
			return array[top];
		}
		
	private:
		T *array;
		int top;	
};

int main(){
	StackArray<char> s;
	
	if (s.isEmpty())
		cout << "Ngan xep dang rong" << endl;
	
	s.push('B'); 
	s.push('E');
	s.push('K');
	s.push('A');
	s.push('C');
	
	cout << s.getTop() << endl;
	cout << s.getSize() << endl;
	
	system("pause");
	return 0;
}
