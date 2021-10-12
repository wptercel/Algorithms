class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : cpdomains) {
            String[] entry = s.split(" ");
            int count = Integer.valueOf(entry[0]);
            map.put(entry[1], map.getOrDefault(entry[1], 0) + count);
            for(int i = entry[1].indexOf('.'); i >= 0; i = entry[1].indexOf('.')) {
                entry[1] = entry[1].substring(i + 1);
                map.put(entry[1], map.getOrDefault(entry[1], 0) + count);
            }
        }
        
        List<String> results = new ArrayList<>(map.size());
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            results.add(entry.getValue() + " " + entry.getKey());
        }
        return results;
    }
}
