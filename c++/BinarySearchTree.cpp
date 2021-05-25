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

template <typename T>
struct Node{
	T data;
	Node* leftChild;
	Node* rightChild;
	
	Node(T data, Node* leftChild, Node* rightChild){
		this->data = data;
		this->leftChild = leftChild;
		this->rightChild = rightChild;
	}
};

template <typename T>
class BinarySearchTree{
	public:
		BinarySearchTree(){
			root = NULL;
		}
		
		~BinarySearchTree(){
			makeEmpty();
		}
		
		void makeEmpty(){
			makeEmpty(root);
		}
		
		void insert(T data){
			insert(data, root);
		}
		
		Node<T>* find(T data){
			return find(data, root);
		}
		
		Node<T>* findMin(){
			return findMin(root);
		}
		
		Node<T>* findMax(){
			return findMax(root);
		}
		
		remove(T data){
			remove(data, root);
		}
		
		Node<T>* getRoot(){
			return root;
		}
		
		
		int findHeight(){
			return findHeight(root);
		}
		
		void preOrderTraversal(){
			preOrderTraversal(root);
		}
		
		void inOrderTraversal(){
			inOrderTraversal(root);
		}
		
		void postOrderTraversal(){
			postOrderTraversal(root);
		}
		
		void levelOrderTraversal(){
			if(root == NULL)
				return;
			QueueArray<Node<T>*> queue;
			queue.enqueue(root);
			while(!queue.isEmpty()){
				Node<T>* front = queue.dequeue();
				cout << front->data << " ";
				if(front->leftChild != NULL)
					queue.enqueue(front->leftChild);
				if(front->rightChild != NULL)
					queue.enqueue(front->rightChild);	
			}
		}
		
		
	private:
		Node<T>* root;
		
		// height of a node is max between height of its left subtree and its right subtree plus 1
		int findHeight(Node<T>* node){
			if(node == NULL)
				return -1;
			int leftHeight = findHeight(node->leftChild);
			int rightHeight = findHeight(node->rightChild);
			return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
		}
		
		Node<T>* findMax(Node<T>* node){
			if(node == NULL)
				return NULL;
			else if(node->rightChild == NULL)
				return node;
			else
				return findMax(node->rightChild);
		}
		
		Node<T>* findMin(Node<T>* node){
			if(node == NULL)
				return NULL;
			else if(node->leftChild == NULL)
				return node;
			else
				return findMin(node->leftChild);
		}
		
		Node<T>* find(T t, Node<T>* node){
			if(node == NULL)
				return NULL;
				
			if(t < node->data)
				return find(t, node->leftChild);
			else if(t > node->data)
				return find(t, node->rightChild);
			else if(t == node->data)
				return node;	
				
		}
		
		void makeEmpty(Node<T>* & node){
			if(node == NULL)
				return;
				
			makeEmpty(node->leftChild);
			makeEmpty(node->rightChild);
			
			delete node;
			node = NULL;	
		}
		
		void insert(T t, Node<T>* & node){
			if(node == NULL){
				node = new Node<T>(t, NULL, NULL);
				return;
			}
			
			if(t <= node->data)
				insert(t, node->leftChild);
			else
				insert(t, node->rightChild);	
		}
		
		void remove(T data, Node<T>* & node){
			if(node == NULL)
				return;
			if(data < node->data)
				remove(data, node->leftChild);
			else if(data > node->data)
				remove(data, node->rightChild);
				
			// node have 2 child -> replace the data of current node by the smallest data of its descendants
			// 					 -> call function remove to the node which have smallest data recursively
			else if(node->leftChild != NULL && node->rightChild != NULL){ 
				Node<T>* minNode = this->findMin(node);
				node->data = minNode->data;
				remove(data, minNode);
			} 
			// Node have 1 child or leaf node 
			else{ 
				Node<T>* oldNode = node;
				node = (node->leftChild != NULL) ? node->leftChild : node->rightChild;
				delete oldNode;
			}	
			
		}
		
		void preOrderTraversal(Node<T>* node){
//			cout << node->data << " ";
//			if(node->leftChild == NULL && node->rightChild == NULL)
//				return;
//			if(node->leftChild != NULL)
//				preOrderTraversal(node->leftChild);
//			if(node->rightChild != NULL)
//				preOrderTraversal(node->rightChild);
			
			if(node == NULL)
				return;
			cout << node->data << " ";
			preOrderTraversal(node->leftChild);
			preOrderTraversal(node->rightChild);
		}
		
		void inOrderTraversal(Node<T>* node){
			if(node == NULL)
				return;
			inOrderTraversal(node->leftChild);
			cout << node->data << " ";
			inOrderTraversal(node->rightChild);
		}
		
		void postOrderTraversal(Node<T>* node){
			if(node == NULL)
				return;
			postOrderTraversal(node->leftChild);
			postOrderTraversal(node->rightChild);
			cout << node->data << " ";
		}
		
};


int main(){
	BinarySearchTree<int> tree;
	
	tree.insert(6);
	tree.insert(2);
	tree.insert(8);
	tree.insert(1);
	tree.insert(5);
	tree.insert(3);
	tree.insert(4);
	
//	tree.remove(8);
	
//	tree.preOrderTraversal();
	tree.levelOrderTraversal();
//	cout<< tree.findMax()->data;	
//	cout<< tree.find(1);
//	cout<< tree.findHeight();
//	cout<< tree.find(8)->leftChild;	
//	cout<< tree.find(8)->rightChild;	
	system("pause");
	return 0;
}













