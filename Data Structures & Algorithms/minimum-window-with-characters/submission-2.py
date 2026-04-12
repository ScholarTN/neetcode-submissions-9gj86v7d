class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""
        
        need = Counter(t)
        have = {}
        formed = 0
        required = len(need)
        
        l = 0
        min_len = float("inf")
        result = ""
        
        for r in range(len(s)):
            char = s[r]
            have[char] = have.get(char, 0) + 1
            
            if char in need and have[char] == need[char]:
                formed += 1
            
            while formed == required:
                if (r - l + 1) < min_len:
                    min_len = r - l + 1
                    result = s[l:r+1]
                
                have[s[l]] -= 1
                if s[l] in need and have[s[l]] < need[s[l]]:
                    formed -= 1
                l += 1
        
        return result