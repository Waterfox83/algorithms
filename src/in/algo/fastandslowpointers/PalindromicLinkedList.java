package in.algo.fastandslowpointers;

import java.util.ArrayList;
import java.util.List;

class PalindromicLinkedList {
    static List<Integer> firstPart = new ArrayList<>();

    private static ListNode findMiddle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            firstPart.add(slowPointer.value);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public static boolean isPalindrome(ListNode head) {
        // TODO: Find the middle node
        ListNode pointer = findMiddle(head);
        System.out.println("Middle: " + pointer.value);
        int currListIndex = firstPart.size();

        while(pointer!=null && pointer.next!=null){
            //Go next in the list
            pointer = pointer.next;
            //Go one back in the array
            currListIndex--;
            System.out.println("element in second part of list: " + pointer.value + ", element in first part of list: " + firstPart.get((currListIndex)));

            if (pointer.value != firstPart.get((currListIndex))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        //2->4->6->4->2
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        //2->4->6->4->2->2
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
