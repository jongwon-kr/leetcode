import java.util.*;
import java.io.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(result, map, "JFK");

        return result;
    }

    void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String from){

        while(map.containsKey(from) && !map.get(from).isEmpty()){
            dfs(result, map, map.get(from).poll());
        }

        result.add(0,from);
    }

}