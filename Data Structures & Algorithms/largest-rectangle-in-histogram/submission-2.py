class Solution:
    def largestRectangleArea(self, heights):
        stack = []
        maxArea = 0
        heights.append(0)
        for i in range(len(heights)):
            while stack and heights[stack[-1]] > heights[i]:
                h = heights[stack.pop()]
                w = i if not stack else i - stack[-1] - 1
                maxArea = max(maxArea, h * w)
            stack.append(i)
        return maxArea