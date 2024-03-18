import java.util.Arrays;
import java.util.Scanner;

public class ReversedStack {
    private int[] stack;
    private int size, top;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeInput = Integer.parseInt(scanner.nextLine());
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ReversedStack q = new ReversedStack(sizeInput);

        for (int i = 0; i < nums.length; i++) {
            q.addLast(nums[i]);
        }

        q.printReversedQueue();
        scanner.close();
    }

    public ReversedStack(int capacity) {
        this.stack = new int[capacity];
        this.size = 0;
        this.top = -1;
    }

    public boolean isFull() {
        return this.size == this.stack.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(int value) {
        if (this.isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue already full.");
        }

        this.size++;
        this.stack[++top] = value;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue already empty.");
        }

        this.size--;
        return this.stack[this.top--];
    }

    public void printReversedQueue() {
        ReversedStack rq = new ReversedStack(this.size);

        for (int i = this.size - 1; i >= 0; i--) {
            rq.addLast(this.pop());
        }

        for (int i = rq.size - 1; i >= 0; i--) {
            int el = rq.pop();
            System.out.println(el);
            this.addLast(el);
        }
    }
}