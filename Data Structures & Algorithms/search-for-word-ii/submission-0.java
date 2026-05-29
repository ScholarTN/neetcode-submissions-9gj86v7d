

class TrieNode {

    HashMap<Character, TrieNode> children;
    String word;

    public TrieNode() {

        children = new HashMap<>();
        word = null;
    }
}

class Solution {

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }

                node = node.children.get(c);
            }

            node.word = word;
        }

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board,
                     int r,
                     int c,
                     TrieNode node,
                     List<String> result) {

        if (r < 0 || c < 0 ||
            r >= board.length ||
            c >= board[0].length) {

            return;
        }

        char ch = board[r][c];

        if (ch == '#' ||
            !node.children.containsKey(ch)) {

            return;
        }

        node = node.children.get(ch);

        if (node.word != null) {

            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        board[r][c] = ch;
    }
}