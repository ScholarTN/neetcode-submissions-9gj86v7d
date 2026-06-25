

class Solution {

    public String foreignDictionary(String[] words) {

        HashMap<Character, HashSet<Character>> adj = new HashMap<>();

        for (String word : words) {

            for (char c : word.toCharArray()) {

                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() &&
                w1.substring(0, minLen).equals(w2.substring(0, minLen))) {

                return "";
            }

            for (int j = 0; j < minLen; j++) {

                if (w1.charAt(j) != w2.charAt(j)) {

                    adj.get(w1.charAt(j)).add(w2.charAt(j));

                    break;
                }
            }
        }

        HashMap<Character, Boolean> visit = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (char c : adj.keySet()) {

            if (dfs(c, adj, visit, res)) {
                return "";
            }
        }

        return res.reverse().toString();
    }

    private boolean dfs(char c,
                        HashMap<Character, HashSet<Character>> adj,
                        HashMap<Character, Boolean> visit,
                        StringBuilder res) {

        if (visit.containsKey(c)) {
            return visit.get(c);
        }

        visit.put(c, true);

        for (char nei : adj.get(c)) {

            if (dfs(nei, adj, visit, res)) {
                return true;
            }
        }

        visit.put(c, false);

        res.append(c);

        return false;
    }
}