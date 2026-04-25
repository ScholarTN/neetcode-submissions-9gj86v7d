class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int total = A.length + B.length;
        int half = total / 2;

        int l = 0, r = A.length;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int Aright = i == A.length ? Integer.MAX_VALUE : A[i];
            int Bleft = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int Bright = j == B.length ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0.0;
    }
}