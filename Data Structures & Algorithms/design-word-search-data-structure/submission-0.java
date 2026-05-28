

class TrieNode {

    HashMap<Character, TrieNode> children;
    boolean end;

    public TrieNode() {

        children = new HashMap<>();
        end = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {

        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }

            node = node.children.get(c);
        }

        node.end = true;
    }

    public boolean search(String word) {

        return dfs(word, 0, root);
    }

    private boolean dfs(String word,
                        int index,
                        TrieNode node) {

        if (index == word.length()) {
            return node.end;
        }

        char c = word.charAt(index);

        if (c == '.') {

            for (TrieNode child : node.children.values()) {

                if (dfs(word,
                        index + 1,
                        child)) {

                    return true;
                }
            }

            return false;
        }

        if (!node.children.containsKey(c)) {
            return false;
        }

        return dfs(word,
                   index + 1,
                   node.children.get(c));
    }
}