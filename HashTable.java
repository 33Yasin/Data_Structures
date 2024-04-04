import java.util.LinkedList;

public class HashTable <K,V>{

    private static final int DEFAULT_CAPACITY = 10;
    private LinkedList<Entry<K,V>>[] table;
    private int size;

    public HashTable(){
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value){
        if(key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);

        if(table[index] == null){
            table[index] = new LinkedList<>();
        }

        for(Entry<K,V> entry: table[index]){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key,value));
        size++;
    }


    public V get(K key){
        if(key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);

        if(table[index] != null){
            for(Entry<K,V> entry : table[index]){
                if(entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public boolean containsKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }


    private int getIndex(K key){
        return Math.abs(key.hashCode()) % table.length;
    }


    private static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println(hashTable.get("one")); // Output: 1
        System.out.println(hashTable.get("two")); // Output: 2
        System.out.println(hashTable.get("three")); // Output: 3

        System.out.println("Size before removal: " + hashTable.size()); // Output: 3
        hashTable.remove("two");
        System.out.println("Size after removal: " + hashTable.size()); // Output: 2
        System.out.println(hashTable.containsKey("two")); // Output: false
    }
}
