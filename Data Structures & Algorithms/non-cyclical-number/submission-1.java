
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = getNext(n);
        }

        return true;
    }

    private int getNext(int n) {
        int total = 0;

        while (n > 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }

        return total;
    }
}