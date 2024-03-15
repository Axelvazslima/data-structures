public class TestingQueue{
    public static void main(String[] args) {
        testToString();
    }

    private static void testToString(){
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
}
