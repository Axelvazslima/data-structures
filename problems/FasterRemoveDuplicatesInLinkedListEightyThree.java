public class FasterRemoveDuplicatesInLinkedListEightyThree {}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Noticed it was sorted so it can be done like this (Much better and faster).
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode aux = head;
        
        while(aux != null && aux.next != null){
            if(aux.val == aux.next.val){
                aux.next = aux.next.next;
            } else {
                aux = aux.next;
            }
        }
        return head;
    }
}