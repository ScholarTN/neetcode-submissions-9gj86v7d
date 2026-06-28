class Solution:

    def reverse(self, x):

        MIN = -2147483648
        MAX = 2147483647

        result = 0

        sign = -1 if x < 0 else 1

        x = abs(x)

        while x:

            digit = x % 10

            x //= 10

            result = result * 10 + digit

        result *= sign

        if result < MIN or result > MAX:
            return 0

        return result