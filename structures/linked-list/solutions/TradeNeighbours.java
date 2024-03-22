import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.Arrays;

class Node{
    int element;
    Node next, prev;

    public Node(int element){
        this.element = element;
    }

    public String toString(){
        return String.valueOf(this.element);
    }
}

class LinkedList{
    Node head, tail;
    int size;

    private boolean isEmpty(){
        return this.size == 0;
    }

    public void addLast(Node node){
        if(this.isEmpty()){
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        this.size++;
    }

    private void removeFirst(){
        if (this.isEmpty()) return;
        if (this.size == 1){
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        this.head.next.prev = null;
        this.head = this.head.next;
        this.size--;
    }

    public void removeLast(){
        if (this.isEmpty()) {
            return;
        }
        if (this.size == 1){
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        this.size--;
    }

    public void removeByIndex(int index){
        if (index == this.size - 1) {
            this.removeLast();
            return;
        }
        if(index == 0){
            this.removeFirst();
            return;
        }
        if (this.isEmpty()) {
            return;
        }
        int idx = 0;
        Node aux = this.head;
        while(aux != null){
            if(idx == index){
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                break;
            }
            aux = aux.next;
            idx++;
        }
    }

    public void swap(int index){
        if (index == this.size - 1) return;
        if (this.isEmpty()) return;
        if (this.size == 1) return;

        int idx = 0;
        Node aux = this.head;
        while(aux != null){
            if(idx == index){
                Node temp = aux.next;
                aux.next = aux.next.next;
                aux.prev.next = temp;
                temp.next.prev = aux;
                temp.prev = aux.prev;
                aux.prev = temp;
                temp.next = aux;
                break;
            }
            aux = aux.next;
            idx++;
        }
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();

        Node aux = this.head;
        while(aux != null){
            out.append(aux);
            if(aux.next != null) out.append(" ");
            aux = aux.next;
        }

        return out.toString();
    }

}

public class TradeNeighbours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(sc.nextLine());

        System.out.println(tradeNeighbours(nums, index));
    }

    private static String tradeNeighbours(int[] nums, int index){
        LinkedList ll = new LinkedList();
        addElementsInLinkedList(nums, ll);
        ll.swap(index);
        return ll.toString();
    }

    private static void addElementsInLinkedList(int[] elements, LinkedList ll){
        for (Integer integer : elements) {
            ll.addLast(new Node(integer));
        }
    }
}
