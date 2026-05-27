
class TrieNode {

    HashMap<Character, TrieNode> children;
    boolean end;

    public TrieNode() {

        children = new HashMap<>();
        end = false;
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {

        root = new TrieNode();
    }

    public void insert(String word) {

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

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            if (!node.children.containsKey(c)) {
                return false;
            }

            node = node.children.get(c);
        }

        return node.end;
    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for (char c : prefix.toCharArray()) {

            if (!node.children.containsKey(c)) {
                return false;
            }

            node = node.children.get(c);
        }

        return true;
    }
}