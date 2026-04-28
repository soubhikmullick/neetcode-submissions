class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, target, 0, temp, res);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> temp, List<List<Integer>> res) {
        if(target==0) {
            res.add(new ArrayList<>(temp));
            return;
        } 
        if(i==nums.length || target < 0) {
            return;
        }
        // dfs(nums, target, i+1, temp, res);
        // temp.add(nums[i]);
        // dfs(nums, target - nums[i], i, temp, res);
        // temp.remove(temp.size()-1);
        temp.add(nums[i]);
        dfs(nums, target - nums[i], i, temp, res);
        temp.remove(temp.size()-1);
        dfs(nums, target, i+1, temp, res);
        
    }
}
