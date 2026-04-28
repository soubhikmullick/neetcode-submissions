class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        Map<Character, Character> hm = new HashMap<>();
        hm.put('(', ')');
        hm.put('{', '}');
        hm.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.empty() && hm.containsValue(c)) {
                char popped = stack.pop();
                if(hm.getOrDefault(popped,'!') != c) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
