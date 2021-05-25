#include<iostream>
using namespace std;


template <typename T>
struct Node{
	T data;
	Node<T> *next;
	
	Node(T data, Node<T> *next){
		this->data = data;
		this->next = next;
	}
};

template <typename T>
class LinkedList{
	public:
		LinkedList(){
			size = 0;
			head = NULL;
		}
		~LinkedList(){
			while(!isEmpty())
				popFront();
		}
		
		int getSize(){
			return size;
		}
		
		bool isEmpty(){
			return head == NULL;
		}
		
		void print(){
			for(Node<T> *i = head; i != NULL; i = i->next)
				cout << i->data << " ";
		}
		
		void pushFront(T data){
			Node<T> *newNode = new Node<T>(data, head);
			head = newNode;
			size++;
		}
		
		void popFront(){
			Node<T> *oldHead = head;
			head = head->next;
			delete oldHead;
			size--;
		}
		
		T get(int index){
			int j = 0;
			for(Node<T> *i = head; i != NULL; i = i->next){
				if(j == index)
					return i->data;
				j++;
			}
		}
		
		void iterativeReversing(){
			if(head == NULL)
				return;
				
			Node<T>* iterator = head;
			Node<T>* previousNode = NULL;
			
			while(iterator != NULL){
				if(iterator-> next == NULL)
					head = iterator;
					
				Node<T>* nextNode = iterator->next;
				iterator->next = previousNode;
				previousNode = iterator;
				iterator = nextNode;
			}
		}
		
		void recursiveReversing(){
			recursiveReversing(head);
		}
		
		void recursivePrint(){
			recursivePrint(head);
		}
		
		void recursiveReservePrint(){
			recursiveReservePrint(head);
		}
		
	private:
		Node<T> *head;
		int size;
		
		void recursivePrint(Node<T>* node){
			if(node == NULL)
				return;
			cout<<node->data<<endl;
			recursivePrint(node->next);
		}
		
		void recursiveReservePrint(Node<T>* node){
			if(node == NULL)
				return;
			recursiveReservePrint(node->next);
			cout<<node->data<<endl;
		}
		
		void recursiveReversing(Node<T>* node){
			if(node->next == NULL){
				head = node;
				return;
			}
				
			recursiveReversing(node->next);
			Node<T>* nextNode = node->next;
			nextNode->next = node;
			node->next = NULL;
			
		}
};

int main(){
	LinkedList<int> list;
	list.pushFront(0);
	list.pushFront(1);
	list.pushFront(2);
	list.pushFront(3);
	list.pushFront(4);
	
	list.recursiveReversing();
//	list.iterativeReversing();
	list.print();


	system("pause");
	return 0;
}
