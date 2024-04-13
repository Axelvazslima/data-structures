import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromLinkedListEightyThree{}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Boolean> values = new HashMap<>();
        ListNode aux = head;
        if(aux == null) return null;
        ListNode out = new ListNode(head.val);
        ListNode auxOut = out;
        values.put(out.val, true);
        while(aux != null){
            if(values.get(aux.val) == null){
                auxOut.next = new ListNode(aux.val);
                auxOut = auxOut.next;
            }
            values.put(aux.val, true);
            aux = aux.next;
        }
        return out;
    }
}