class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        Arrays.sort(sA);
        Arrays.sort(tA);

        String a = "", b = "";
        for(char c : sA){
            a += c;
        }

        for(char c : tA){
            b += c;
        }

        if(a.equals(b)){
            return true;
        }
        
        return false;
    }
}