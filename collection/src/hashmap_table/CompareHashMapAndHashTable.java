package hashmap_table;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class CompareHashMapAndHashTable {


    Hashtable hashtable = new Hashtable();

    @Test
    public void putHashMap(){
        HashMap hashMap = new HashMap();
        hashMap.put("key2","suSan");
        hashMap.put("value2", 24);
        Object put = hashMap.put("name", "abc");
        System.out.println(put);
        System.out.println(hashMap);
    }
}
