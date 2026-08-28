package org.example.DSA.linkedlist.operation;

public class insertNodeInLinkedlist {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static void iterateList(Node node){
        Node currentNode = node;
        while(currentNode != null){
            System.out.print(currentNode.data+" -> ");
            currentNode = currentNode.next;
        }
    }

    private Node AddElementInList(Node head,Node newNode,int position) {
        if(position == 1){
            newNode.next = head;
            return newNode;
        }

        Node currentNode = head;
        for(int i=0; i<position - 1 && currentNode!=null; i++){
            currentNode = currentNode.next;
        }

        if(currentNode != null){
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        return head;
    }


    void main(){
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(25);
        Node node4 = new Node(40);
        Node node5 = new Node(50);

        Node newNode = new Node(30);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;



        System.out.println("Before adding element");
        iterateList(node1);

        Node result = AddElementInList(node1,newNode,3);
        System.out.println("After adding element");
        iterateList(result);


    }



}
