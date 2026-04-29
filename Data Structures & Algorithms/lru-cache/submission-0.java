class LRUCache {
    int capacity;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> usageOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        usageOrder = new ArrayList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        
        usageOrder.remove((Integer) key);
        usageOrder.add(key);

        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
           
            map.put(key, value);

           
            usageOrder.remove((Integer) key);
            usageOrder.add(key);
        } else {
            if (map.size() == capacity) {
                
                int oldestKey = usageOrder.remove(0);
                map.remove(oldestKey);
            }

            
            map.put(key, value);
            usageOrder.add(key);
        }
    }
}