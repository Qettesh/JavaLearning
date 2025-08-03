
public class Main {
    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>();

        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Orange");

        for (String element : queue) {
            System.out.println(element);
        }

        queue.dequeue();

        System.out.println("Front element: " + queue.peek());
        System.out.println("All elements: " + queue);
        }
}

