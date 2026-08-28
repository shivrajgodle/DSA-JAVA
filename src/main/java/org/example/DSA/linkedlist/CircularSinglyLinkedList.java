package org.example.DSA.linkedlist;

public class CircularSinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void main(){
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1; //Circular Link

        Node currentNode = node1;
        Node startNode = node1;
        System.out.print(currentNode.data + " -> ");
        currentNode = currentNode.next;
        while(currentNode != startNode){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("....");  // Indicating the list loops back
    }

}
