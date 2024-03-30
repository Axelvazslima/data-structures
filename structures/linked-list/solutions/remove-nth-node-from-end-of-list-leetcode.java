class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode aux = head;
        if(aux.next == null){
            head = null;
            return head;
        }

        int i = 0;
        int len = findLength(head);

        if(n == len) head = aux.next;
        while(aux != null){
            i++;
            int idx = len - i;
            if(idx == n){
                if(aux.next != null){
                    aux.next = aux.next.next;
                    return head;
                }
            }
            aux = aux.next;
        }
        return head;
    }

    private int findLength(ListNode head){
        int i = 0;
        ListNode aux = head;
        while(aux != null){
            i++;
            aux = aux.next;
        }
        return i;
    }
}
