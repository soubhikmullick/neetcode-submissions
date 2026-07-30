class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Create a frequency array for the 26 lowercase English letters
            char[] count = new char[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++; 
            }
            
            // Convert the frequency array to a string to use as a Hash Map key.
            // (In Java, char can hold values up to 65,535, so this safely handles large counts)
            String key = new String(count);
            
            // Add the original string to the corresponding anagram group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        // Return all the grouped lists as a single list of lists
        return new ArrayList<>(map.values());
    }
}
