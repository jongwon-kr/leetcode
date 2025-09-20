class Solution {
    public boolean canFinish(int numCourses, int[][] prs) {
        Map<Integer, List<Integer>> finToTake = new HashMap<>();

        for(int[] pr : prs){
            finToTake.putIfAbsent(pr[0], new ArrayList<>());
            finToTake.get(pr[0]).add(pr[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();

        for(Integer fin : finToTake.keySet()){
            if(!dfs(finToTake, fin, takes, taken)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> finToTake, Integer fin, List<Integer> takes, List<Integer> taken){

        if(takes.contains(fin)){
            return false;
        }

        if(taken.contains(fin)){
            return true;
        }

        if(finToTake.containsKey(fin)){

            takes.add(fin);

            for(Integer take : finToTake.get(fin)){
                
                if(!dfs(finToTake, take, takes, taken)){
                    return false;
                }
            }
            
            takes.remove(fin);
            taken.add(fin);
        }

        return true;
    }
}