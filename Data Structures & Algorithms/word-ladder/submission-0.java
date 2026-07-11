class Solution {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        int L = beginWord.length();

        HashMap<String, ArrayList<String>> map =
                new HashMap<>();

        wordList.add(beginWord);

        for (String word : wordList) {

            for (int i = 0; i < L; i++) {

                String pattern =
                        word.substring(0, i)
                        + "*"
                        + word.substring(i + 1);

                map.putIfAbsent(pattern,
                        new ArrayList<>());

                map.get(pattern).add(word);
            }
        }

        Queue<String> queue =
                new LinkedList<>();

        HashSet<String> visited =
                new HashSet<>();

        queue.offer(beginWord);

        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                for (int i = 0; i < L; i++) {

                    String pattern =
                            word.substring(0, i)
                            + "*"
                            + word.substring(i + 1);

                    ArrayList<String> neighbors =
                            map.getOrDefault(
                                    pattern,
                                    new ArrayList<>());

                    for (String nei : neighbors) {

                        if (!visited.contains(nei)) {

                            visited.add(nei);

                            queue.offer(nei);
                        }
                    }

                    map.put(pattern,
                            new ArrayList<>());
                }
            }

            level++;
        }

        return 0;
    }
}