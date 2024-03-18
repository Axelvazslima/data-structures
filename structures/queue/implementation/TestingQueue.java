import java.util.Scanner;

public class TestingQueue{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case 1 -> testAddLastAndToString();
            case 2 -> testRemoveFirst();
            case 3 -> testIsEmpty();
            case 4 -> testIsFull();
            default -> System.out.println("Invalid Input");
        }

        scanner.close();
    }

    private static void testAddLastAndToString(){
        Queue queue = new Queue();
        System.out.println(queue);
        queue.addLast(10);
        System.out.println(queue);
        queue.removeFirst();
        System.out.println(queue);
        for (int i = 0; i < 100; i++) {
            queue.addLast(i);
        }
        System.out.println(queue);
    }

    private static void testRemoveFirst(){
        Queue queue = new Queue();
        System.out.println(queue);
        for (int i = 0; i < 10; i++) {
            queue.addLast(i);
        }
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            queue.removeFirst();
        }
        System.out.println(queue);
        queue.removeFirst();
        System.out.println(queue);
    }

    private static void testIsEmpty(){
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.addLast(3);
        System.out.println(queue.isEmpty());
        queue.removeFirst();
        System.out.println(queue.isEmpty());
    }

    private static void testIsFull(){
        Queue queue = new Queue();
        System.out.println(queue.isFull());
        for (int i = 0; i < 20; i++) {
            queue.addLast(i);
        }
        System.out.println(queue.isFull());
        queue.removeFirst();
        System.out.println(queue.isFull());
        queue.addLast(3);
        System.out.println(queue.isFull());
        queue.addLast(22);
        System.out.println(queue.isFull());

    }
}
