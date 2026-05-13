

class Solution {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {

            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}