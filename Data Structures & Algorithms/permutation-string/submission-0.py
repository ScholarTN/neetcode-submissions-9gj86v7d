class Solution:
    def checkInclusion(self, s1, s2):
        if len(s1) > len(s2):
            return False
        need = [0] * 26
        window = [0] * 26
        for c in s1:
            need[ord(c) - ord('a')] += 1
        l = 0
        for r in range(len(s2)):
            window[ord(s2[r]) - ord('a')] += 1
            if r - l + 1 > len(s1):
                window[ord(s2[l]) - ord('a')] -= 1
                l += 1
            if window == need:
                return True
        return False