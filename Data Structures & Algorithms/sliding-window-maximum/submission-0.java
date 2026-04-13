class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[r]) {
                dq.pollLast();
            }
            dq.offerLast(nums[r]);
            if (r - l + 1 > k) {
                if (dq.peekFirst() == nums[l]) dq.pollFirst();
                l++;
            }
            if (r - l + 1 == k) {
                res[l] = dq.peekFirst();
            }
        }
        return res;
    }
}