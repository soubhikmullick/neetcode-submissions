class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) {
            hs.add(i);
        }
        int longest = 0;
        for(int i=0; i<nums.length; i++) {
            int length = 1;
            while(hs.contains(nums[i]+length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
