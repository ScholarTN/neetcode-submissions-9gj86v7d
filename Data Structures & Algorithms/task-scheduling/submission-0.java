class Solution {

    public static int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxFreq = 0;

        for (int num : count) {
            maxFreq = Math.max(maxFreq, num);
        }

        int maxCount = 0;

        for (int num : count) {
            if (num == maxFreq) {
                maxCount++;
            }
        }

        return Math.max(tasks.length,
                (maxFreq - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }
}
