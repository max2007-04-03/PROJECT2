public class MyQueue<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public T poll() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null; // If queue becomes empty
        }
        size--;
        return value;
    }
}