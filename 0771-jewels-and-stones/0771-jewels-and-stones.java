class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for(char c : jewels.toCharArray()){
            map.put(c,true);
        }

        int result = 0;
        for(char s : stones.toCharArray()){
            if(map.get(s) != null){
                result++;
            }
        }

        return result;
    }
}