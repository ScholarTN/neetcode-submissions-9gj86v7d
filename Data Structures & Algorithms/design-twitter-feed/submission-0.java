
class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followeeId : followMap.get(userId)) {

            if (tweetMap.containsKey(followeeId)) {

                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;

                int[] tweet = tweets.get(index);

                maxHeap.offer(new int[]{
                        tweet[0],
                        tweet[1],
                        followeeId,
                        index - 1
                });
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty() && result.size() < 10) {

            int[] current = maxHeap.poll();

            int tweetId = current[1];
            int followeeId = current[2];
            int nextIndex = current[3];

            result.add(tweetId);

            if (nextIndex >= 0) {

                int[] nextTweet =
                        tweetMap.get(followeeId).get(nextIndex);

                maxHeap.offer(new int[]{
                        nextTweet[0],
                        nextTweet[1],
                        followeeId,
                        nextIndex - 1
                });
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)
                && followeeId != followerId) {

            followMap.get(followerId).remove(followeeId);
        }
    }
}