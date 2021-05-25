#include <iostream>
#include<string>

using namespace std;

void removeDuplicatedChar(string &s){
	string temp;
	for(int i = 0; i < s.length(); i++){
		bool trung = false;
		for(int j = 0; j < temp.length(); j++)
			if(s[i] == temp[j]){
				trung = true;
				break;
			}
		
		if(!trung)
			temp.push_back(s[i]);	
	}
	s.clear();
	s = temp;
}

int main(){
	string str = "aaacccsssfffasdqwreqw";
	removeDuplicatedChar(str);
	cout<< str;
	system("pause");
	return 0;
}


