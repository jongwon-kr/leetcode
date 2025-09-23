import java.util.*;
import java.io.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[][] dist = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        pq.offer(new int[]{0, src, 0});
        dist[0][src] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int node = current[1];
            int stops = current[2];

            if (node == dst) {
                return cost;
            }

            if (stops > k) {
                continue;
            }
            
            if (adj.containsKey(node)) {
                for (int[] neighbor : adj.get(node)) {
                    int nextNode = neighbor[0];
                    int nextCost = neighbor[1];
                    int newCost = cost + nextCost;
                    
                    if (newCost < dist[stops + 1][nextNode]) {
                        dist[stops + 1][nextNode] = newCost;
                        pq.offer(new int[]{newCost, nextNode, stops + 1});
                    }
                }
            }
        }

        return -1;
    }
}