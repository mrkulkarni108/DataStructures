#include<iostream>

using namespace std;

struct Node{
    int data;
    Node* next;
    Node* prev;
};

class LinkedList{
    public:
    Node* head;
    LinkedList(){
        head = NULL;
    }
    Node* NewNode(){
        Node* newnode = new Node();
        newnode->data = 0;
        newnode->next = NULL;
        newnode->prev = NULL;
        return newnode;
    }
    void Traverse(){
        Node* temp = head;
        if(temp != NULL){
            cout<<temp->data<<" ";
            temp = temp->next;
            Traverse();
        }
        cout<<endl;
    }
    // void Traverse(int position){
    // }
    void insertAtEnd(int val){
        Node* newnode = NewNode();
        newnode->data = val;
        if(head == NULL){
            head = newnode;
            return;
        }
        Node* temp = head;
        Traverse();
        temp->next = newnode;
        newnode->prev = temp;
    }
    void insertAtBeginning(int val){
        Node* newnode = NewNode();
        newnode->data = val;
        if(head == NULL){
            head = newnode;
            return;
        }
        newnode->next = head;
        head->prev = newnode;
        head = newnode;
    }

    void insertAtPosition(int val, int pos){
        Node* newnode = NewNode();
        newnode->data = val;
        if(pos == 0){
            insertAtBeginning(val);
            return;
        }
        Node* temp = head;
        for(int i=0; i<pos-9; i++){
            temp = temp->next;
        }
        newnode->next = temp->next;
        newnode->prev = temp;
        temp->next = newnode;
        if(newnode->next != NULL){
            newnode->next->prev = newnode;
        }
    }
    // void DeleteNodeFromEnd(){
    //     Node* temp = head;
    //     while
    // }

    // void DeleteNodeFromBeginning(){

    // // }

    // // void DeleteNodeFromPosition(int pos){

    // // }
    void display(){
        Node* temp = head;
        while(temp != NULL){
            cout<<temp->data<<" ";
            temp = temp->next;
        }
        cout<<endl;
    }
};


int main(){
    LinkedList list;
    
    cout<<"Doubly Linked List Operations:"<<endl;
    cout<<"1.Insert Node\n2.Delete Node\n3.Display List\n";
    int choice;
    cin>>choice;
    if(choice == 1){
        cout<<"1.Inserting Value at end.\n2.Inserting Value at Beginning.\n3.Inserting Value at Position.\n4.Back to main Menu"<<endl;
        int insertChoice;
        cin>>insertChoice;
        if(insertChoice == 1){
            int val;
            cout<<"Enter Value to insert at end: ";
            cin>>val;
            list.insertAtEnd(val);
        }
        else if(insertChoice == 2){
            int val;
            cout<<"Enter Value to insert at Beginning: ";
            cin>>val;
            list.insertAtBeginning(val);
        }
        else if(insertChoice == 3){
            int val, pos;
            cout<<"Enter Value to insert: ";
            cin>>val;
            cout<<"Enter Position to insert at: ";
            cin>>pos;
            list.insertAtPosition(val, pos);
        }
        else{
            main();
        }
    }
    else if(choice == 2){

    }
    else if(choice == 3){
        list.display();
    }
    else if(choice == 4){
        return 0;
    }
    main();
    return 0;

}