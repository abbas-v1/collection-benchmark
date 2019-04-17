package net.bitoasis.linkedlist;

import it.unimi.dsi.fastutil.floats.Float2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author abbas
 */
public class Main {

    public static void main(String[] args) {

        treeMapImpl();
        linkedListImpl();
        arrayListImpl();
        fastUtilListImpl();
        fastUtilIntTreeMapImpl();
        fastUtilFloatTreeMapImpl();

    }

    private static void arrayListImpl() {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        ArrayList<Integer> arrayList = generateRandomIntegerArrayList();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(arrayList.get(i));
        }
        printExecutionTime("ArrayList add : ", start, System.nanoTime());
        
        System.out.println("List size : " + list.size());

        start = System.nanoTime();
        for (int i = 0; i < 7_000; i++) {
            Integer first = list.remove(0);
        }
        printExecutionTime("ArrayList remove 0 : ", start, System.nanoTime());

        Collections.shuffle(arrayList);
        
        start = System.nanoTime();
        for (int i = 0; i < 1_500; i++) {
            boolean status = list.remove(arrayList.get(i));
        }
        printExecutionTime("ArrayList remove : ", start, System.nanoTime());
        
        System.out.println("List size : " + list.size());
    }

    private static void linkedListImpl() {
        
        LinkedList<Integer> list = new LinkedList<>();
        
        ArrayList<Integer> arrayList = generateRandomIntegerArrayList();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(arrayList.get(i));
        }
        printExecutionTime("LinkedList add : ", start, System.nanoTime());

        System.out.println("Map size : " + list.size());
        
        start = System.nanoTime();
        for (int i = 0; list.size() > 0; i++) {
            Integer first = list.removeFirst();
        }
        printExecutionTime("LinkedList remove first : ", start, System.nanoTime());

        Collections.shuffle(arrayList);
        
        start = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            boolean status = list.remove(arrayList.get(i));
        }
        printExecutionTime("LinkedList remove : ", start, System.nanoTime());
        
        System.out.println("Map size : " + list.size());
    }

    private static void fastUtilListImpl() {

        IntArrayList list = new IntArrayList();

        int[] intArray = generateRandomIntArray();
        
        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(intArray[i]);
        }
        printExecutionTime("FastUtil LinkedList add : ", start, System.nanoTime());
        
        System.out.println("List size : " + list.size());

        start = System.nanoTime();
        for (int i = 0; i < 7_000; i++) {
            int first = list.removeInt(0);
        }
        printExecutionTime("FastUtil LinkedList remove 0 : ", start, System.nanoTime());

        shuffleArray(intArray);
        
        start = System.nanoTime();
        for (int i = 0; i < 5_000; i++) {
            boolean status = list.rem(intArray[i]);
        }
        printExecutionTime("FastUtil LinkedList remove : ", start, System.nanoTime());
        
        System.out.println("List size : " + list.size());
    }

    private static void fastUtilIntTreeMapImpl() {

        Int2ObjectLinkedOpenHashMap map = new Int2ObjectLinkedOpenHashMap();
        
        int[] intArray = generateRandomIntArray();

        long start = System.nanoTime();
        Object object = new Object();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(intArray[i], object);
        }
        printExecutionTime("FastUtil TreeMap put : ", start, System.nanoTime());

        System.out.println("Map size : " + map.size());
        
        start = System.nanoTime();
        for (int i = 0; map.size() > 0; i++) {
            Object first = map.removeFirst();
        }
        printExecutionTime("FastUtil TreeMap firstKey : ", start, System.nanoTime());

        shuffleArray(intArray);
        
        start = System.nanoTime();
        for (int i = 0; map.size() > 0; i++) {
            Object status = map.remove(intArray[i]);
        }
        printExecutionTime("FastUtil TreeMap remove : ", start, System.nanoTime());
        
        System.out.println("Map size : " + map.size());
    }

    private static void fastUtilFloatTreeMapImpl() {

        Float2ObjectLinkedOpenHashMap map = new Float2ObjectLinkedOpenHashMap();

        float[] floatArray = generateRandomFloatArray();
        
        long start = System.nanoTime();
        Object object = new Object();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(floatArray[i], object);
        }
        printExecutionTime("FastUtil TreeMap put : ", start, System.nanoTime());

        System.out.println("Map size : " + map.size());
        
        start = System.nanoTime();
        for (int i = 0; map.size() > 0; i++) {
            Object first = map.removeFirst();
        }
        printExecutionTime("FastUtil TreeMap firstKey : ", start, System.nanoTime());

        shuffleArray(floatArray);
        
        start = System.nanoTime();
        for (int i = 0; map.size() > 0; i++) {
            Object status = map.remove(floatArray[i]);
        }
        printExecutionTime("FastUtil TreeMap remove : ", start, System.nanoTime());
        
        System.out.println("Map size : " + map.size());
    }

    private static void treeMapImpl() {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        ArrayList<Integer> arrayList = generateRandomIntegerArrayList();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(arrayList.get(i), i);
        }
        printExecutionTime("TreeMap put : ", start, System.nanoTime());

        System.out.println("Map size : " + map.size());
        
        start = System.nanoTime();
        for (int i = 0; map.size() > 0; i++) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
        }
        printExecutionTime("TreeMap firstKey : ", start, System.nanoTime());

        Collections.shuffle(arrayList);
        
        start = System.nanoTime();
        for (int i = 0; map.size() > 0; i++) {
            Integer status = map.remove(arrayList.get(i));
        }
        printExecutionTime("TreeMap remove : ", start, System.nanoTime());
        
        System.out.println("Map size : " + map.size());

    }

    private static void printExecutionTime(String message, long start, long end) {
        long time = (end - start) / 1_000_000;
        System.out.println(message + time);
    }

    private static void shuffleArray(int[] ar) {

        Random random = new Random();

        for (int i = ar.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    
    private static void shuffleArray(float[] ar) {

        Random random = new Random();

        for (int i = ar.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            float a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    
    private static ArrayList<Integer> generateRandomIntegerArrayList() {
        Random random = new Random();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(random.nextInt(1_000_000));
        }
        
        return arrayList;
    }
    
    private static int[] generateRandomIntArray() {
        Random random = new Random();

        int[] intArray = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            intArray[i] = random.nextInt(1_000_000);
        }
        
        return intArray;
    }
    
    private static float[] generateRandomFloatArray() {
        Random random = new Random();

        float[] floatArray = new float[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            floatArray[i] = random.nextFloat();
        }
        
        return floatArray;
    }

}
