class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {")": "(", "}": "{", "]": "["}

        for char in s:
            if char in mapping:   # closing bracket
                if stack and stack[-1] == mapping[char]:
                    stack.pop()
                else:
                    return False
            else:                 # opening bracket
                stack.append(char)

        return len(stack) == 0