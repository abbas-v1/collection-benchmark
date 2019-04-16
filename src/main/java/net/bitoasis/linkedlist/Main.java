package net.bitoasis.linkedlist;

import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author abbas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Integer> addingItems = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            addingItems.add(random.nextInt(1_000_000));
        }

        ArrayList<Integer> searchingItems = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            searchingItems.add(random.nextInt(1_000_000));
        }

        treeMapImpl(addingItems, searchingItems);
        linkedListImpl(addingItems, searchingItems);
        arrayListImpl(addingItems, searchingItems);
        fastUtilListImpl();
        fastUtilTreeMapImpl();

    }

    private static void arrayListImpl(ArrayList<Integer> addingItems, ArrayList<Integer> searchingItems) {
        ArrayList<Integer> list = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(addingItems.get(i));
        }
        printExecutionTime("ArrayList add : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < 6_000; i++) {
            Integer first = list.remove(0);
        }
        printExecutionTime("ArrayList remove 0 : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < 6_00; i++) {
            boolean status = list.remove(searchingItems.get(i));
        }
        printExecutionTime("ArrayList remove : ", start, System.nanoTime());
    }

    private static void linkedListImpl(ArrayList<Integer> addingItems, ArrayList<Integer> searchingItems) {
        LinkedList<Integer> list = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(addingItems.get(i));
        }
        printExecutionTime("LinkedList add : ", start, System.nanoTime());

        System.out.println("Map size : " + list.size());
        start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            Integer first = list.removeFirst();
        }
        printExecutionTime("LinkedList get 0 : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < 3_00; i++) {
            boolean status = list.remove(searchingItems.get(i));
        }
        printExecutionTime("LinkedList remove : ", start, System.nanoTime());
    }

    private static void fastUtilListImpl() {

        Random random = new Random();

        int[] addArray = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            addArray[i] = random.nextInt(1_000_000);
        }

        int[] searchArray = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            searchArray[i] = random.nextInt(1_000_000);
        }

        IntArrayList list = new IntArrayList();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(addArray[i]);
        }
        printExecutionTime("FastUtil LinkedList add : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            int first = list.removeInt(0);
        }
        printExecutionTime("FastUtil LinkedList remove 0 : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            boolean status = list.rem(searchArray[i]);
        }
        printExecutionTime("FastUtil LinkedList remove : ", start, System.nanoTime());
    }

    private static void fastUtilTreeMapImpl() {

        Random random = new Random();

        int[] addArray = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            addArray[i] = random.nextInt(1_000_000);
        }

        int[] searchArray = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            searchArray[i] = random.nextInt(1_000_000);
        }

        Int2ObjectLinkedOpenHashMap map = new Int2ObjectLinkedOpenHashMap();

        long start = System.nanoTime();
        Object object = new Object();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(addArray[i], object);
        }
        printExecutionTime("FastUtil TreeMap put : ", start, System.nanoTime());

        System.out.println("Map size : " + map.size());
        start = System.nanoTime();
        for (int i = 0; i < map.size(); i++) {
            Object first = map.removeFirst();
        }
        printExecutionTime("FastUtil TreeMap firstKey : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < map.size(); i++) {
            Object status = map.remove(searchArray[i]);
        }
        printExecutionTime("FastUtil TreeMap remove : ", start, System.nanoTime());
    }

    private static void treeMapImpl(ArrayList<Integer> addingItems, ArrayList<Integer> searchingItems) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(addingItems.get(i), i);
        }
        printExecutionTime("TreeMap put : ", start, System.nanoTime());

        System.out.println("Map size : " + map.size());
        start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
        }
        printExecutionTime("TreeMap firstKey : ", start, System.nanoTime());

        start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            Integer status = map.remove(searchingItems.get(i));
        }
        printExecutionTime("TreeMap remove : ", start, System.nanoTime());

    }

    private static void printExecutionTime(String message, long start, long end) {
        long time = (end - start) / 1_000_000;
        System.out.println(message + time);
    }

}
