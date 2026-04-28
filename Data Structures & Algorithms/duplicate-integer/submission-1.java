class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(!hs.contains(nums[i])) hs.add(nums[i]);
            else return true;
        }
        return false;
    }
}