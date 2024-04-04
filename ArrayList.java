import java.util.Arrays;

public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public ArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T element){
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] = element;
    }
    private void ensureCapacity(){
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " , Size: " + size);
        }
        return (T)elements[index];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public boolean remove(T element){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private void removeAt(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void clear(){
        Arrays.fill(elements, null);
        size = 0;
    }

    public boolean contains(T element){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void replace(int index, T element){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.add(6);

        arrList.display();

        System.out.println(arrList.contains(3));
        System.out.println(arrList.contains(7));

        System.out.println(arrList.size());

        arrList.replace(0,9);
        arrList.display();

        arrList.remove(5);
        arrList.display();

        System.out.println(arrList.get(0));

    }

}
