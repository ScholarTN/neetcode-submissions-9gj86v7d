

class Solution {

    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        HashSet<Integer> dp = new HashSet<>();

        dp.add(0);

        for (int num : nums) {

            HashSet<Integer> next =
                    new HashSet<>(dp);

            for (int sum : dp) {

                next.add(sum + num);
            }

            dp = next;
        }

        return dp.contains(target);
    }
}