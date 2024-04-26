import java.util.Arrays;
import java.util.Scanner;

class HeapSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pair[] pairs = new Pair[10];
        for (int i = 0; i < 10; i++) {
            pairs[i] = new Pair(String.valueOf(i), i);
        }

        Heap heap = new Heap(pairs);
        System.out.println(heap);
        System.out.println(Arrays.toString(heap.heapSort()));
    }
}

class Heap{
    Pair[] heap;
    int tail;
    private final int DEFAULT_CAPACITY = 10;

    public Heap(int capacity){
        this.heap = new Pair[capacity];
        this.tail = -1;
    }

    public Heap(){
        this.heap = new Pair[this.DEFAULT_CAPACITY];
        this.tail = -1;
    }

    public Heap(Pair[] pairs){
        this.heap = pairs;
        this.tail = pairs.length - 1;
        this.buildHeap();
    }

    public int parent(int index){
        return (int) (index - 1) / 2;
    }

    public int left(int index){
        return (2 * index) + 1;
    }

    public int right(int index){
        return 2 * (index + 1);
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    public void buildHeap(){
        if (this.isEmpty()) return;
        int start = this.parent(this.tail);

        for (int i = start; i >= 0; i--) {
            this.heapify(i);
        }
    }

    public void add(Pair pair){
        this.tail++;

        if (this.tail >= this.heap.length) this.resize();

        this.heap[this.tail] = pair;
        this.heapify(this.parent(this.tail));
    }

    public void resize(){
        Pair[] newHeap = new Pair[this.heap.length * 2];
        for (int i = 0; i <= this.tail; i++) {
            newHeap[i] = this.heap[i];
        }

        this.heap = newHeap;
    }

    public boolean isLeaf(int index){
        return index > this.parent(this.tail) && index <= tail;
    }

    public void heapify(int index){
        if (this.isLeaf(index) || !this.isValidIndex(index)) return;

        int maxIndex = this.maxIndex(index, this.left(index), this.right(index));

        if (maxIndex != index) {
            this.swap(index, maxIndex);
            this.heapify(maxIndex);
        }
    }

    public Pair remove(){
        if (this.heap[0] == null) return null;

        Pair out = this.heap[0];
        this.heap[0] = this.heap[this.tail];
        this.tail--;

        this.heapify(0);
        return out;
    }

    public void swap(int i, int j){
        Pair aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    @Override
    public String toString(){
        String out = "";
        for (int i = 0; i < heap.length; i++) {
            out += heap[i];
            out += ", ";
        }
        return out.trim();
    }

    public boolean isValidIndex(int index){
        return index >= 0 && index <= this.tail;
    }

    public int maxIndex(int index, int left, int right){
        int maxIndex = index;

        if (this.isValidIndex(left) && this.heap[maxIndex].getPriority() < this.heap[left].getPriority()) {
            maxIndex = left;
        }

        if (this.isValidIndex(right) && this.heap[maxIndex].getPriority() < this.heap[right].getPriority()) {
            maxIndex = right;
        }

        return maxIndex;
    }

    public Pair[] heapSort(){
        Pair[] out = new Pair[this.heap.length];
        int originalTail = this.tail;

        for (int i = out.length - 1; i >= 0; i--) {
            out[i] = this.remove();
        }

        this.tail = originalTail;
        return out;
    }
}

class Pair{
    String element;
    int priority;

    public Pair(String element, int priority){
        this.element = element;
        this.priority = priority;
    }

    public int getPriority(){
        return this.priority;
    }

    @Override
    public String toString(){
        return String.valueOf(this.priority);
    }
}