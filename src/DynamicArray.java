import java.lang.reflect.Array;

public class DynamicArray<T> {

    private int size = 0;
    private int initialCapacity = 0;
    private Object[] data;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public void insert(int index, T value){
        if(size == initialCapacity) {
            resize();
        }

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Error");
        }
        for (int j = size; j > index; j--) {
            data[j] = data[j - 1];
        }

        data[index] = value;
        size++;
    }

    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Error");
        }
        return (T)data[index];
    }

    public void set(int index, T value) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Error");
        }
        data[index] = value;
    }

    public void add(T value) {
        if(size == initialCapacity) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public void remove(int index) {
        for(int i = index + 1; i < data.length; i++) {
            data[i - 1] = data[i];
        }

        size--;
    }

    private void resize() {
        initialCapacity = initialCapacity * 2;
        Object[] newArray = new Object[initialCapacity];
        for(int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }

        data = newArray;
    }

    public int getSize() {
        return size;
    }
}
