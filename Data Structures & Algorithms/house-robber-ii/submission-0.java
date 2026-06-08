class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(
                helper(nums, 0, nums.length - 2),
                helper(nums, 1, nums.length - 1)
        );
    }

    private int helper(int[] nums,
                       int start,
                       int end) {

        int rob1 = 0;
        int rob2 = 0;

        for (int i = start; i <= end; i++) {

            int temp =
                    Math.max(nums[i] + rob1,
                             rob2);

            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}