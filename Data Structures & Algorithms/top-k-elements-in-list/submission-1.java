class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        
        PriorityQueue<Integer> heap =
            new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        
        for (int n : freq.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
            result[i] = heap.poll();
        
        return result;
    }
}