class Solution:
    def carFleet(self, target, position, speed):
        pairs = sorted(zip(position, speed), reverse=True)
        stack = []
        for p, s in pairs:
            time = (target - p) / s
            stack.append(time)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
        return len(stack)