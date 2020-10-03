package in.algo.fastandslowpointers;

public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println("Middle: " + slowPointer.value);
        return slowPointer;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //1->2->3->4->5
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
        //1->2->3->4->5->6
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
        //1->2->3->4->5->6->7
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
}
