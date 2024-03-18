import java.util.Arrays;
import java.util.Scanner;

public class ReversedStackIndex {
    private int[] stack;
    private int size, top;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeInput = Integer.parseInt(scanner.nextLine());
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ReversedStackIndex s = new ReversedStackIndex(sizeInput);
        int limitIndex = Integer.parseInt(scanner.nextLine());

        System.out.println("-");
        for (int i = 0; i < nums.length; i++) {
            s.push(nums[i]);
        }

        s.printReversedStack(limitIndex);
        scanner.close();
    }

    public ReversedStackIndex(int capacity) {
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

    public void push(int value) {
        if (this.isFull()) {
            throw new ArrayIndexOutOfBoundsException("Stack already full.");
        }

        this.size++;
        this.stack[++top] = value;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack already empty.");
        }

        this.size--;
        return this.stack[this.top--];
    }

    public void printReversedStack(int limitIndex) {
        ReversedStackIndex rs = new ReversedStackIndex(this.size);
        ReversedStackIndex control = new ReversedStackIndex(this.size);

        for (int i = 0; i <= limitIndex; i++) {
            int el = this.pop();
            rs.push(el);
            control.push(el);
        }

        while (!rs.isEmpty()) {
            System.out.println(rs.pop());
        }

        while(!this.isEmpty()){
            int el = this.pop();
            System.out.println(el);
            control.push(el);
        }

        while (!control.isEmpty()) {
            this.push(control.pop());
        }

        System.out.println(Arrays.toString(this.stack));
    }
}
