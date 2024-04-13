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
        int Ll1Number = LlAsNumber(l1);
        int Ll2Number = LlAsNumber(l2);

        long sum = (long) (Ll1Number + Ll2Number);

        String sumStr = String.valueOf(sum);
        int lengthSumStr = sumStr.length();
        ListNode out = new ListNode(Character.getNumericValue(sumStr.charAt(lengthSumStr - 1)));
        ListNode auxOut = out;
        for (int i = lengthSumStr - 2; i >= 0; i--) {
            auxOut.next = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
            auxOut = auxOut.next;
        }
        return out;
    }

    private int LlAsNumber(ListNode ll){
        int sizeLl = sizeOf(ll);
        int control = sizeLl;
        ListNode auxLl = ll;
        int LlNumber = 0;
        while(auxLl != null){
            LlNumber += auxLl.val * (Math.pow(10, sizeLl - control));
            auxLl = auxLl.next;
            control--;
        }
        return LlNumber;
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
}
