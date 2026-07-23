
class Solution {

    private HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {

        return dfs(0, 0, nums, target);
    }

    private int dfs(int index,
                    int total,
                    int[] nums,
                    int target) {

        if (index == nums.length) {

            return total == target ? 1 : 0;
        }

        String key = index + "," + total;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int positive =
                dfs(index + 1,
                    total + nums[index],
                    nums,
                    target);

        int negative =
                dfs(index + 1,
                    total - nums[index],
                    nums,
                    target);

        memo.put(key, positive + negative);

        return memo.get(key);
    }
}