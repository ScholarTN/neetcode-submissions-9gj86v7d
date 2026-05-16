
class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {

        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        small.offer(num);

        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}