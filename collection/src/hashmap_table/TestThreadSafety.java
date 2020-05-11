package hashmap_table;

import java.util.concurrent.ConcurrentHashMap;

public class TestThreadSafety {

    public static final ConcurrentHashMap<String, String> firstHashMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                firstHashMap.put(String.valueOf(i),String.valueOf(i));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 50; i < 100; i++) {
                firstHashMap.put(String.valueOf(i),String.valueOf(i));
            }
        });

        thread1.start();
        thread2.start();
        Thread.currentThread().sleep(1000);
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ":" + firstHashMap.get(String.valueOf(i)));
        }
    }
}
