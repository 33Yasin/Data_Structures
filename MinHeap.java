import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int minIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] < heap[minIndex]) {
            minIndex = left;
        }

        if (right < size && heap[right] < heap[minIndex]) {
            minIndex = right;
        }

        if (index != minIndex) {
            swap(index, minIndex);
            heapifyDown(minIndex);
        }
    }

    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size++] = value;
        heapifyUp(size - 1);
    }

    public int extractMin() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public void printHeap() {
        System.out.println("Heap: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.insert(8);
        minHeap.insert(11);
        minHeap.insert(3);

        minHeap.printHeap();

        System.out.println("Extracted min: " + minHeap.extractMin());
        minHeap.printHeap();
    }
}
