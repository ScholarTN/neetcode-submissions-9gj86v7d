class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        sol(digits, "", list);
        return list;
    }

    public void sol(String st, String ans, List<String> list) {
        if (st.length() == 0) {
            list.add(ans); 
            return;
        }

        char ch = st.charAt(0);
        String get = getLetters(ch);

        for (int i = 0; i < get.length(); i++) {
            sol(st.substring(1), ans + get.charAt(i), list);
        }
    }

    public String getLetters(char ch) {
        if (ch == '2') return "abc";
        if (ch == '3') return "def";
        if (ch == '4') return "ghi";
        if (ch == '5') return "jkl";
        if (ch == '6') return "mno";
        if (ch == '7') return "pqrs";
        if (ch == '8') return "tuv";
        if (ch == '9') return "wxyz";
        return ""; 
    }
}