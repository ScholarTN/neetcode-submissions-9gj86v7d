class Solution:
    def minEatingSpeed(self, piles, h):
        l, r = 1, max(piles)
        res = r
        while l <= r:
            k = (l + r) // 2
            total = 0
            for p in piles:
                total += (p + k - 1) // k
            if total <= h:
                res = k
                r = k - 1
            else:
                l = k + 1
        return res