class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index,
                           int[] candidates,
                           int target,
                           List<Integer> combination,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (index >= candidates.length || target < 0) {
            return;
        }

        combination.add(candidates[index]);

        backtrack(index,
                  candidates,
                  target - candidates[index],
                  combination,
                  result);

        combination.remove(combination.size() - 1);

        backtrack(index + 1,
                  candidates,
                  target,
                  combination,
                  result);
    }
}