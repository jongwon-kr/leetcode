class Solution {
    
    class Element{
        int d;
        int[] point;
        public Element(int d, int[] point) {
            this.d = d;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        List<Element> list = new ArrayList<>();
        int[][] results = new int[k][2];     

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            list.add(new Element((x * x) + (y * y), points[i]));
        }
        
        Collections.sort(list, Comparator.comparing((Element e) -> e.d));

        for(int i = 0; i < k; i++){
            results[i] = list.get(i).point;
        }

        return results;
    }
}