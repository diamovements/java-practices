package Pr3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class SyncMap<K, V> implements Map<K, V> {
    private final Map<K, V> map;

    SyncMap() {
        this.map = new HashMap<>();
    }

    @Override
    public synchronized int size() {
        return map.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public synchronized V get(Object key) {
        return map.get(key);
    }

    @Override
    public synchronized V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public synchronized V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public synchronized void clear() {
        map.clear();
    }

    @Override
    public synchronized Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public synchronized Collection<V> values() {
        return map.values();
    }

    @Override
    public synchronized Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}

class Main {
    public static void main(String[] args) {
        SyncMap<Integer, String> map = new SyncMap<>();
        Runnable writer = () -> {
            for (int i = 0; i < 10; i++) {
                map.put(i, "Val " + i);
                System.out.println(Thread.currentThread().getName() + " wrote: " + i);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Runnable reader = () -> {
            for (int i = 0; i < 10; i++) {
                map.get(i);
                System.out.println(Thread.currentThread().getName() + " read: " + i);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread writer1 = new Thread(writer);
        Thread writer2 = new Thread(writer);
        Thread reader1 = new Thread(reader);
        Thread reader2 = new Thread(reader);

        writer1.start();
        writer2.start();
        reader1.start();
        reader2.start();

        try {
            writer1.join();
            writer2.join();
            reader1.join();
            reader2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Map: ");
        map.entrySet().forEach(System.out::println);
    }
}
