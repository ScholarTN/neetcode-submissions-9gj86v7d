
class Solution {

    HashMap<String, LinkedList<String>> graph =
            new HashMap<>();

    LinkedList<String> itinerary =
            new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        tickets.sort((a, b) ->
                b.get(1).compareTo(a.get(1)));

        for (List<String> ticket : tickets) {

            graph.putIfAbsent(
                    ticket.get(0),
                    new LinkedList<>());

            graph.get(ticket.get(0))
                    .add(ticket.get(1));
        }

        dfs("JFK");

        return itinerary;
    }

    private void dfs(String airport) {

        LinkedList<String> destinations =
                graph.get(airport);

        while (destinations != null &&
                !destinations.isEmpty()) {

            String next =
                    destinations.removeLast();

            dfs(next);
        }

        itinerary.addFirst(airport);
    }
}