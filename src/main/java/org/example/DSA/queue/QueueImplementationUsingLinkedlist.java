package org.example.DSA.queue;

public class QueueImplementationUsingLinkedlist {


    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.iterateQueue();
        System.out.println(q.peek());
        q.dequeue();
        q.dequeue();
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

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        this.front = this.front.next;
        length--;
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