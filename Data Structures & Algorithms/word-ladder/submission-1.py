from collections import defaultdict, deque

class Solution:
    def ladderLength(self, beginWord, endWord, wordList):

        if endWord not in wordList:
            return 0

        L = len(beginWord)

        patternMap = defaultdict(list)

        wordList.append(beginWord)

        for word in wordList:
            for i in range(L):
                pattern = word[:i] + "*" + word[i + 1:]
                patternMap[pattern].append(word)

        q = deque([(beginWord, 1)])

        visited = {beginWord}

        while q:

            word, level = q.popleft()

            if word == endWord:
                return level

            for i in range(L):

                pattern = word[:i] + "*" + word[i + 1:]

                for nei in patternMap[pattern]:

                    if nei not in visited:

                        visited.add(nei)

                        q.append((nei, level + 1))

                patternMap[pattern] = []

        return 0