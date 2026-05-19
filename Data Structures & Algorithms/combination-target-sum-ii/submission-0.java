class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); 
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    void findCombinations(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); 
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; 

            if (nums[i] > target) break;

            current.add(nums[i]);
            findCombinations(nums, target - nums[i], i + 1, current, result);
            current.remove(current.size() - 1); 
        }
    }
}