
class Twitter:

    def __init__(self):
        self.time = 0
        self.followMap = defaultdict(set)
        self.tweetMap = defaultdict(list)

    def postTweet(self, userId: int, tweetId: int) -> None:

        self.tweetMap[userId].append([self.time, tweetId])
        self.time += 1

    def getNewsFeed(self, userId: int):

        maxHeap = []

        self.followMap[userId].add(userId)

        for followeeId in self.followMap[userId]:

            if followeeId in self.tweetMap:

                tweets = self.tweetMap[followeeId]
                index = len(tweets) - 1

                time, tweetId = tweets[index]

                heapq.heappush(
                    maxHeap,
                    [-time, tweetId, followeeId, index - 1]
                )

        result = []

        while maxHeap and len(result) < 10:

            time, tweetId, followeeId, nextIndex = heapq.heappop(maxHeap)

            result.append(tweetId)

            if nextIndex >= 0:

                nextTime, nextTweetId = \
                    self.tweetMap[followeeId][nextIndex]

                heapq.heappush(
                    maxHeap,
                    [-nextTime,
                     nextTweetId,
                     followeeId,
                     nextIndex - 1]
                )

        return result

    def follow(self, followerId: int, followeeId: int) -> None:

        self.followMap[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:

        if followeeId != followerId:
            self.followMap[followerId].discard(followeeId)