

class Solution {

    private HashMap<String, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices) {

        return dfs(0, true, prices);
    }

    private int dfs(int day,
                    boolean buying,
                    int[] prices) {

        if (day >= prices.length) {
            return 0;
        }

        String key = day + "," + buying;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int profit;

        if (buying) {

            int buy =
                    -prices[day] +
                    dfs(day + 1,
                        false,
                        prices);

            int skip =
                    dfs(day + 1,
                        true,
                        prices);

            profit =
                    Math.max(buy,
                             skip);

        } else {

            int sell =
                    prices[day] +
                    dfs(day + 2,
                        true,
                        prices);

            int hold =
                    dfs(day + 1,
                        false,
                        prices);

            profit =
                    Math.max(sell,
                             hold);
        }

        memo.put(key, profit);

        return profit;
    }
}