class Solution {
    public int minCostClimbingStairs(int[] cost) 
    {
        int first = 0,second=0;

        for(int i =0;i<cost.length;i++)
        {
            int curr = cost[i]+Math.min(first,second);
            first = second;
            second = curr;
        }
        return Math.min(first,second);
    }
}
