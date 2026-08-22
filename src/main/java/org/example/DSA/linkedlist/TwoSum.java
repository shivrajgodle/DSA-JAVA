package org.example.DSA.linkedlist;


public class TwoSum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + carry;

            int digit = sum % 10;
            carry = sum / 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(String name, ListNode node) {

        System.out.print(name + ": ");

        while (node != null) {
            System.out.print(node.val);

            if (node.next != null) {
                System.out.print(" → ");
            }

            node = node.next;
        }

        System.out.println();
    }

    // Convert reverse-order linked list to normal number
    public static int getNumber(ListNode node) {

        int number = 0;
        int multiplier = 1;

        while (node != null) {
            number += node.val * multiplier;
            multiplier *= 10;
            node = node.next;
        }

        return number;
    }

    public static void main(String[] args) {

        // Node 1 = 342
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        // Node 2 = 465
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        // Add two numbers
        ListNode result = addTwoNumbers(node1, node2);

        // Display input and result
        printList("Node 1", node1);
        printList("Node 2", node2);
        printList("Result", result);

        // Display actual calculation
        int number1 = getNumber(node1);
        int number2 = getNumber(node2);
        int resultNumber = getNumber(result);

        System.out.println();
        System.out.println("Calculation:");
        System.out.println(number1 + " + " + number2 + " = " + resultNumber);
    }
}