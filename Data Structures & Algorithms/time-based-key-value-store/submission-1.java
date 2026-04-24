class TimeMap {

    private Map<String, List<Pair>> map;

    class Pair {
        int time;
        String val;
        Pair(int t, String v) {
            time = t;
            val = v;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid).time <= timestamp) {
                res = list.get(mid).val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}