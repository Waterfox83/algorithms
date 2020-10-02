package in.algo.fastandslowpointers;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        //1->2->3->4->5->6
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        //1->2->3->4->5->6->3
//        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head)); //returns true;
        cycleLength(head);

        head.next.next.next.next.next.next = head.next.next.next;
        //1->2->3->4->5->6->4
//        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
        cycleLength(head);
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer!=null && fastPointer.next!=null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == slowPointer) {
                return true;
            }
        }

        return false;
    }

    private static int cycleLength(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int cycleLength = 0;

        while (fastPointer!=null && fastPointer.next!=null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == slowPointer) {
                break;
            }
        }
//        System.out.println(slowPointer.value);
        ListNode current = slowPointer;
        current = current.next;
        cycleLength++;

        while (current!=slowPointer) {
            current = current.next;
            cycleLength++;
        }
        System.out.println("Cycle length: " + cycleLength);
        return cycleLength;
    }

}
