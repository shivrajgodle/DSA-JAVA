package org.example.DSA.linkedlist;

public class CircularDoublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    void main(){
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        node1.next = node2;
        node1.prev = node4; // circular link

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node4;

        node4.prev = node3;
        node4.next = node1; // circular link

        System.out.println("Traversing forword");
        Node currentNode = node1;
        Node startNode = node1;
        System.out.print(currentNode.data + " -> ");
        currentNode = currentNode.next;
        while(currentNode != startNode){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("...");  // Indicating the list loops back

        System.out.println("Traversing backword");
        currentNode = node4;
        startNode = node4;
        System.out.print(currentNode.data + " -> ");
        currentNode = currentNode.prev;
        while(currentNode != startNode){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.prev;
        }

        System.out.println("...");  // Indicating the list loops back

    }
}
