package org.example.DSA.queue;

public class QueueImplementationUsingLinkedlist {


    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.iterateQueue();
        System.out.println(q.peek());
        System.out.println("dequeued:-"+q.dequeue());
        System.out.println("dequeued:-"+q.dequeue());
        q.iterateQueue();

    }

}

class QueueLL{
    Node front;
    Node rear;
    int length;

    public QueueLL(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public void enqueue(char data){
        Node newNode = new Node(data);
        if(rear == null){
            this.front = this.rear = newNode;
            this.length++;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
        this.length++;
    }

    public char dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        Node temp = this.front;
        this.front = temp.next;
        if(this.front == null){
            this.rear = null;
        }
        length--;
        return temp.data;
    }

    public void iterateQueue(){
        Node currentNode = front;
        while(currentNode != null){
            System.out.print(currentNode.data+" -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public int size(){
        return this.length;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    public char peek(){
        return this.front.data;
    }
}

class Node {
    char data;
    Node next;

    Node(char data){
        this.data = data;
        this.next = null;
    }
}