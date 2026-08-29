package org.example.DSA.queue;

public class QueueImplementationUsingArray {

    void main() {
        Queue q = new Queue(5);
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('d');
        q.enqueue('e');

        q.printQueue();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.printQueue();
        System.out.println(q.peek());
        System.out.println(q.size());
    }

}


class Queue {
    int capacity;
    int front = 0;
    int size = 0;
    char[] queue;

    public Queue(int capacity){
        this.capacity = capacity;
        queue = new char[capacity];
    }

    public void enqueue(char data){
        if(size == capacity){
            System.out.println("Queue is full");
            return;
        }
        queue[(front + size) % capacity] = data;
        size++;
    }

    void printQueue(){
        for(int i = 0; i < size; i++){
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public char dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return '\u0000';
        }

        char item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public char peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}