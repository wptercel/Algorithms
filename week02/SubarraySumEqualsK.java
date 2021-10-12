class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= nums.length; i++){
            Integer matchCount = map.get(preSum[i] - k);
            if(matchCount != null) {
                result += matchCount;
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return result;
    }
}
