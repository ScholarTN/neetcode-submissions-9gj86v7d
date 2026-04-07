class Solution {
    public int maxArea(int[] heights) 
    {
       int r = heights.length-1;
       int l = 0;
       int res = 0;

       while(l<r) 
       {
            res = Math.max(res,(r-l)*Math.min(heights[r],heights[l]));
            if(heights[l]<heights[r])
            {
                l++;
            }
            else
            {
                r--;
            }

       }
       return res;
    }
}
