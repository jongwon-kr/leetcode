class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letList = new ArrayList<>();
        List<String> digList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digList.add(log);
            } else {
                letList.add(log);
            }
        }

        letList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        String[] result = new String[logs.length];
        int index = 0;
        
        for (String log : letList) {
            result[index++] = log;
        }
        
        for (String log : digList) {
            result[index++] = log;
        }

        return result;
    }
}