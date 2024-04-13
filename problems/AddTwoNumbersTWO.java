import java.lang.StringBuilder;
import java.math.BigInteger;

// Leet Code problem 2 - Add two Number using reversed LinkedList
public class AddTwoNumbersTWO{}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Aux = l1;
        int idx = sizeOf(l1);
        String[] l1Array = new String[idx];
        idx--;
        while(l1Aux != null){
            l1Array[idx] = String.valueOf(l1Aux.val);
            l1Aux = l1Aux.next;
            idx--;
        }
        BigInteger l1Int = getLlAsInt(l1Array);

        ListNode l2Aux = l2;
        idx = sizeOf(l2);
        String[] l2Array = new String[idx];
        idx--;
        while(l2Aux != null){
            l2Array[idx] = String.valueOf(l2Aux.val);
            l2Aux = l2Aux.next;
            idx--;
        }
        BigInteger l2Int = getLlAsInt(l2Array);

        BigInteger sum = l1Int.add(l2Int);
        return turnSumIntoReversedLinkedList(sum);
    }

    private int sizeOf(ListNode ln){
        ListNode aux = ln;
        int counter = 0;
        while(aux != null){
            counter++;
            aux = aux.next;
        }
        return counter;
    }

    private BigInteger getLlAsInt(String[] nums){
        String out = "";
        for(String str : nums){
            if(str != null)out+=str;
        }
        return new BigInteger(out);
    }

    private ListNode turnSumIntoReversedLinkedList(BigInteger sum){
        StringBuilder temp = new StringBuilder(String.valueOf(sum));
        String aux = temp.reverse().toString();
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(aux.charAt(0))));
        ListNode out = head;
        for(int i = 1; i < aux.length(); i++){
            out.next = new ListNode(Integer.parseInt(String.valueOf(aux.charAt(i))));
            out = out.next;
        }
        return head;
    }
}
