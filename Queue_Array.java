public class Queue_Array {

    private int maxSize;
    private Object[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue_Array(int size){
        maxSize = size;
        queueArray = new Object[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public void enqueue(Object data){
        if(isFull()){
            System.out.println("Queue is full !!!");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
    }

    public Object dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty !!!");
            return -1;
        }
        Object data = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return data;
    }

    public Object peek(){
        if(isEmpty()){
            System.out.println("Queue is empty !!!");
            return -1;
        }
        return queueArray[front];
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Queue_Array queue = new Queue_Array(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued element: " + queue.dequeue());

        queue.display();

        System.out.println("Peeked element: " + queue.peek());
    }

}
