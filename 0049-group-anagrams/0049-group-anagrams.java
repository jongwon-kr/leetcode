class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, ArrayList<String>> results = new HashMap<>();

        for (String str : strs) {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);

            String key = String.valueOf(cArr);

            if (!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }
            results.get(key).add(str);
        }

        return new ArrayList<>(results.values());
    }
}