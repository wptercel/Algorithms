class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int result = 0;
        Map<Integer, State> traverser = new HashMap<>(); // number: (firstIndex, count)
        for(int i = 0; i < nums.length; i++) {
            State existing = traverser.get(nums[i]);
            if(existing == null) {
                traverser.put(nums[i], new State(i, 1));
            } else {
                traverser.get(nums[i]).count++;
            }
            
            existing = traverser.get(nums[i]);
            if(degree < existing.count) {
                degree = existing.count;
                result = i - existing.firstIndex + 1;
            } else if(degree == existing.count) {
                result = Math.min(result, i - existing.firstIndex + 1);
            }
        }
        return result;
    }

    private class State{
        public int firstIndex;
        public int count;
        public State(int firstIndex, int count) {
            this.firstIndex = firstIndex;
            this.count = count;
        }
    }
}
