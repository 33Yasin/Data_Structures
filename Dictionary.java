public class Dictionary {

    private String[] keys;
    private String[] values;
    private int size;

    public Dictionary(int capacity){
        keys = new String[capacity];
        values = new String[capacity];
        size = 0;
    }

    public void put(String key, String value){
        for (int i = 0; i < size; i++){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public String get(String key){
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }


    public void remove(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                // Anahtarı bulduk, şimdi sil
                for (int j = i; j < size - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                size--;
                return;
            }
        }
    }


    public boolean containsKey(String key){
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {

        Dictionary d = new Dictionary(10);
        d.put("apple", "elma");
        d.put("banana", "muz");
        d.put("cherry", "kiraz");

        System.out.println("Anahtar: apple, Değer: " + d.get("apple"));
        System.out.println("Anahtar: banana, Değer: " + d.get("banana"));
        System.out.println("Anahtar: cherry, Değer: " + d.get("cherry"));
        System.out.println("Anahtar: grape, Değer: " + d.get("grape")); // Bu anahtar yok, null dönecek

        d.remove("banana");
        System.out.println("Anahtar: banana, Değer: " + d.get("banana")); // Bu anahtar artık yok, null dönecek

        System.out.println("Anahtar apple var mı? " + d.containsKey("apple"));
        System.out.println("Değer muz var mı? " + d.containsValue("muz"));
    }


}
