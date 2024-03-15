import java.lang.StringBuilder;

public class Queue{
    private int[] queue;
    private int size, head, tail;
    private int final DEFAULT_CAPACITY = 20;
    private double final DOUBLE_CAPACITY = 2.0;
    private double final HALF_CAPACITY = 0.5;

    public Queue(){
        this.queue = new int[20];
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void addLast(int value){
        if (this.size == this.queue.length) {
            this.populateQueue(this.DOUBLE_CAPACITY);
        }
        this.queue[this.tail++] = value;
    }

    public int removeFirst(){
        int element = this.head++;

        if ((this.size <= this.queue.length / 4) && (this.size > this.DEFAULT_CAPACITY * 2)) {
            this.fixQueue(this.HALF_CAPACITY);
        } else {
            this.shiftLeft();
        }

        return element;
    }

    private int fixQueue(double newSize){
        this.shiftLeft();
        this.populateQueue(newSize);
    }

    private void shiftLeft(){
        int j = this.head;
        for (int i = 0; i <= this.queue.size; i++) {
            this.swap(this.queue, i, j);
            j++;
        }
    }

    private int[] populateQueue(double newSize){
            int[] temp = new int[Integer.parseInt(this.size * newSize)];
            for (int i = this.head; i < this.queue.length; i++) {
                temp[i] = this.queue[i];
            }
            this.size = Integer.parseInt(newSize);
            return temp;
    }

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public String toString(){
        StringBuilder output = new StringBuilder("queue(");
        if (this.isEmpty()) return output.append(" empty )").toString();
        for (int i = 0; i <= this.size; i++) {
            output.append(this.queue[i]);
            if (i < this.size) output.append(", ");
        }
        return output.append(")").toString();
    }
}
