public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    // Внутрішній клас Node
    private static class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    // Додає елемент в кінець списку
    public void add(Object value) {
        Node newNode = new Node(value, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    // Видаляє елемент за індексом
    public void remove(int index) {
        Node nodeToRemove = getNode(index);

        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            tail = nodeToRemove.prev;
        }

        size--;
    }

    // Очищає колекцію
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Повертає розмір колекції
    public int size() {
        return size;
    }

    // Повертає елемент за індексом
    public Object get(int index) {
        return getNode(index).value;
    }

    // Допоміжний метод для отримання ноди за індексом
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}