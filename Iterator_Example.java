import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_Example {
    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("c++");
        myList.add("javascript");

        Iterator<String> iterator = myList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



        ArrayList<Integer> myNums = new ArrayList<>();
        myNums.add(3);
        myNums.add(4);
        myNums.add(5);

        Iterator<Integer> iter = myNums.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
