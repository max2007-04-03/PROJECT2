import java.util.EmptyStackException;

public class MyStack<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            pop();
            return;
        }

        Node<T> current = top;
        Node<T> prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        if (prev != null) {
            prev.next = current.next;
        }
        size--;
    }
}
