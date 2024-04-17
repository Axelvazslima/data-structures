import java.util.*;
import java.lang.StringBuilder;

class MergeTwoSortedLinkedLists{
    public static void main(String[] args) {
        LinkedList llOne = new LinkedList();
        LinkedList llTwo = new LinkedList();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) llOne.add(i);
            else llTwo.add(i);
        }

        System.out.println(llOne);
        System.out.println(llTwo);
        System.out.println(mergeTwoSortedLinkedLists(llOne, llTwo));
    }

    public static LinkedList mergeTwoSortedLinkedLists(LinkedList llOne, LinkedList llTwo) {
        LinkedList out = new LinkedList();

        Node auxOne = llOne.head;
        Node auxTwo = llTwo.head;
        while(auxOne != null && auxTwo != null){
            if(auxOne.value < auxTwo.value){
                out.add(auxOne.value);
                auxOne = auxOne.next;
            } else{
                out.add(auxTwo.value);
                auxTwo = auxTwo.next;
            }
        }

        while(auxOne != null){
            out.add(auxOne.value);
            auxOne = auxOne.next;
        }

        while(auxTwo != null){
            out.add(auxTwo.value);
            auxTwo = auxTwo.next;
        }

        return out;
    }
}


class LinkedList{
    Node head;
    Node tail;
    int size;

    public void add(int v){
        Node newNode = new Node(v);

        if (this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            this.size++;
            return;
        }

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.size++;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString(){
        Node aux = this.head;

        StringBuilder out = new StringBuilder();
        while(aux != null){
            out.append(aux.value);
            if(aux.next != null) out.append(" -> ");
            aux = aux.next;
        }
        return out.toString();
    }

}

class Node{
    int value;
    Node next;
    Node prev;

    public Node(int value){
        this.value = value;
    }
}
