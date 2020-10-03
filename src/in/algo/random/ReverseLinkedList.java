package in.algo.random;

import in.algo.fastandslowpointers.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        reverseLinkedList(head);
    }

    private static void reverseLinkedList(ListNode head){
        ListNode current = head;
        ListNode previous = null;

        while(current!=null && current.next!=null){
            ListNode next = current.next;
            System.out.println("Current: " + current.value+", Next: " + next.value);
            current.next = previous;
            previous = current;
            current = next;
        }
        current.next = previous;

        while(current!=null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

    }
}
