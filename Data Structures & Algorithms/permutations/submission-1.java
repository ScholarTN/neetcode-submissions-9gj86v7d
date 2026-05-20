

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,
                  new ArrayList<>(),
                  new boolean[nums.length],
                  result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> permutation,
                           boolean[] used,
                           List<List<Integer>> result) {

        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;

            permutation.add(nums[i]);

            backtrack(nums,
                      permutation,
                      used,
                      result);

            permutation.remove(permutation.size() - 1);

            used[i] = false;
        }
    }
}