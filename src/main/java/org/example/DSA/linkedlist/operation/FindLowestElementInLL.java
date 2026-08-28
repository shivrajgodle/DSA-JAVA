package org.example.DSA.linkedlist.operation;

public class FindLowestElementInLL {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void main(){
        Node node1 = new Node(60);
        Node node2 = new Node(10);
        Node node3 = new Node(34);
        Node node4 = new Node(22);
        Node node5 = new Node(89);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println("Lowest element is:"+findLowestElement(node1));
    }

    private int findLowestElement(Node node1) {
        int minValue = node1.data;
        Node currentNode = node1.next;

        while (currentNode != null){
            if(currentNode.data < minValue){
                minValue = currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return minValue;
    }
}
