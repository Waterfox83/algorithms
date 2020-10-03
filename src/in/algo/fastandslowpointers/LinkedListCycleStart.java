package in.algo.fastandslowpointers;

public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        int cycleLength = LinkedListCycle.cycleLength(head);
        ListNode slowPointer = head;
//        System.out.println("Slow Pointer start: " + head.value);
        ListNode fastPointer = head;
        for (int i = 0; i < cycleLength; i++) {
            fastPointer = fastPointer.next;
        }
//        System.out.println("Fast pointer: " + fastPointer.value);
        while(slowPointer!=fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return fastPointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        //1->2->3->4->5->6->3
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        //1->2->3->4->5->6->4
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        //1->2->3->4->5->6->1
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }

}
