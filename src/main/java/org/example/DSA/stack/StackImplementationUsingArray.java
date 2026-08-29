package org.example.DSA.stack;

public class StackImplementationUsingArray {
    void main() {
        Stack s = new Stack(5);
        s.push('s');
        s.push('h');
        s.push('i');
        s.push('v');
        s.printStack();
        s.pop();
        s.printStack();
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }
}


class Stack {
    char[] stack;
    int top;
    int capacity;

    public Stack(int capacity){
        this.capacity = capacity;
        this.stack = new char[capacity];
        top = -1;
    }

    public void push(char element){
        if(top == capacity - 1){
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = element;
    }

    public char pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return ' ';
        }
       return stack[top--];
    }

    public char peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return ' ';
        }
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity -1;
    }

    public int size(){
        return top + 1;
    }

    public void printStack(){
        for(int i=0;i<=top;i++){
            System.out.println(stack[i]+" ");
        }
        System.out.println();
    }
}
