package arraylist;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
       List<String> mylist = new ArrayList();
        mylist.add("a");
        mylist.add("b");
        mylist.add("c");
        mylist.add("d");

        for (String word: mylist) {
            if (word.equals("c")){
                mylist.remove(mylist.indexOf("c"));
            }
        }
        System.out.println(mylist);
    }
}
