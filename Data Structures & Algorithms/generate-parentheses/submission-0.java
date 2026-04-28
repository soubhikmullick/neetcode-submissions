class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        backtracking(0,0,n,temp,res);
        return res;
    }

    private void backtracking(int openN, int closeN, int n, StringBuilder temp, List<String> res) {
        if(openN == closeN && openN == n) {
            res.add(temp.toString());
            return;
        }
         if(openN > closeN) {
            temp.append(')');
            backtracking(openN, closeN+1, n, temp, res);
            temp.deleteCharAt(temp.length()-1);
        } if(openN < n) {
            temp.append('(');
            backtracking(openN+1, closeN, n, temp, res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
