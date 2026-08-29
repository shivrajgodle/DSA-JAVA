package org.example.DSA.stack;

public class StackImplementationUsingLinkedlist {

    void main() {
        StackwithLinkedlist s = new StackwithLinkedlist();

        s.push('s');
        s.push('h');
        s.push('i');
        s.push('v');


        s.IterateStack();
        System.out.println("------------------");
        System.out.println("poping:-"+s.pop());
        s.IterateStack();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println("poping:-"+s.pop());
        s.IterateStack();
    }
}

class StackwithLinkedlist {
    Node head;
    int size;

    public StackwithLinkedlist(){
        head = null;
        size = 0;
    }

    public void push(char data){
        Node newNode = new Node(data);
        if(head != null){
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public char pop(){
        if(isEmpty()){
            return ' ';
        }
        char popped = head.data;
        head = head.next;
        size--;
        return popped;
    }

    public void IterateStack(){
        Node currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
    }

    public char peek(){
        if(isEmpty()){
            return ' ';
        }
        return head.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size + 1;
    }
}



class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

