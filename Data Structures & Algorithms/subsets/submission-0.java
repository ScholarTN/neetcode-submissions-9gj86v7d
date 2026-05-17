

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index,
                           int[] nums,
                           List<Integer> subset,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {

            subset.add(nums[i]);

            backtrack(i + 1, nums, subset, result);

            subset.remove(subset.size() - 1);
        }
    }
}