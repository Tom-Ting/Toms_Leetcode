import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T146_M_LRUCache {
    private int capacity;
    Map<Integer, Integer> cache = new HashMap<>();
    Queue<Integer> key_queue = new PriorityQueue<>();
    public T146_M_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (key_queue.size() == capacity){
            cache.remove(key_queue.peek());
        }
        if (cache.containsKey(key)){
            cache.put(key, value);
        }else {
            cache.put(key, value);
        }
    }
}
