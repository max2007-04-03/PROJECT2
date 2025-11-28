public class MyArrayList {
    private Object[] array;
    private int size;


    public MyArrayList() {
        this.array = new Object[10];
        this.size = 0;
    }


    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(Object value) {
        if (this.size == this.array.length) {
            Object[] newArray = new Object[this.array.length * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }
        this.array[this.size++] = value;
    }
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);

        this.size--;

        this.array[this.size] = null;
    }


    public int size() {
        return this.size;
    }
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        this.size = 0;
    }
}


