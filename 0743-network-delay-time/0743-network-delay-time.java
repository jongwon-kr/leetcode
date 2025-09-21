class Pair {
    int node, distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        int[] distance = new int[n+1];
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Pair>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < times.length; i++) {
            adjList.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        distance[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparing((Pair p)-> p.distance).reversed());
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int diff = cur.distance;

            for(Pair pp : adjList.get(node)) {
                int newNode = pp.node;
                int newDist = pp.distance;

                if(distance[newNode] > diff+newDist) {
                    distance[newNode] = diff+newDist;
                    pq.add(new Pair(newNode, diff+newDist));
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE) return -1;
            else {
                res = Math.max(res, distance[i]);
            }
        }

        return res;
    }
}