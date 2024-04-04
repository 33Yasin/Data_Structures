import java.util.Arrays;

public class DynamicArray {
    private Object[] array;
    private int size;
    private int capacity;

    public DynamicArray(){
        capacity = 10;
        array = new Object[capacity];
        size = 0;
    }

    public void add(Object element){
        if (size == capacity){
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Geçersiz index: " + index);
        }
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
    }

    public Object get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Geçersiz index: " + index);
        }
        return array[index];
    }

    public boolean contains(Object element){
        for (int i = 0; i < size; i++){
            if (array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object element){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1; // Eleman bulunamadı
    }

    public int size() {
        return size;
    }

    public void printArray() {
        System.out.println(Arrays.toString(Arrays.copyOf(array, size)));
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(21);
        dynamicArray.add(8);
        dynamicArray.add(53);
        dynamicArray.add(5);

        dynamicArray.printArray();
        System.out.println(dynamicArray.indexOf(53));
        System.out.println(dynamicArray.get(1));
    }
}
