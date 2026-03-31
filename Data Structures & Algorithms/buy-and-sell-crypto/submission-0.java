class Solution {
    public int maxProfit(int[] prices) 
    {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;

        for (int price:prices)
        {
            if (price<minPrice)
            {
                minPrice = price;
            }
            else
            {
                int profit = price-minPrice;
                maxPrice = Math.max(maxPrice,profit);
            }
        }
        return maxPrice;
    }
}
