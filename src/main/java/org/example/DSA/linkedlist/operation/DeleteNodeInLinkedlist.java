package org.example.DSA.linkedlist.operation;

public class DeleteNodeInLinkedlist {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void iterateList(Node head){
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data+" -> ");
            currentNode = currentNode.next;
        }
    }

    public Node deleteNode(Node head, Node nodetoDelete){
        if(head == nodetoDelete){
            return head.next;
        }

        Node currentNode = head;
        while(currentNode.next != null && currentNode.next != nodetoDelete){
            currentNode = currentNode.next;
        }

        if(currentNode.next == null){
            return head;
        }
        currentNode.next = currentNode.next.next;

        return head;
    }


    void main(){
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        DeleteNodeInLinkedlist dnl = new DeleteNodeInLinkedlist();
        dnl.iterateList(node1);
        System.out.println("");
        System.out.println("---------------------");
        Node result = dnl.deleteNode(node1,node4);
        dnl.iterateList(result);

    }
}
