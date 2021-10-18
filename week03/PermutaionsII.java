/**
    思路：按全排列的逻辑找到左右排列，过程中用一个Set + 特征值来判断是否重复。
    空间复杂度：n
    时间复杂度：一个n叉树，总共n层，每一层都要访问n个节点。但判断used相当于剪枝，所以每层访问的节点量逐层递减。n * (n - 1) * (n - 2) *...* 1 = O(n!)
 */
class Solution {
    private boolean[] used; // nums的下标是否使用过
    private Set<Integer> dupChecker; // 存得到的排列的特征数，如果存在则不算所结果
    private int[] nums; // 共享nums
    private List<List<Integer>> results; // 共享results

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.used = new boolean[nums.length];
        this.dupChecker = new HashSet<>();
        this.nums = nums;
        this.results = new ArrayList<>();
        recurse(new ArrayList<Integer>());
        return this.results;
    }

    private void recurse(List<Integer> tempResult) {
        if(tempResult.size() == this.nums.length) {
            if(this.dupChecker.add(calcCharacteristicNumber(tempResult))){
                this.results.add(new ArrayList<>(tempResult));
            }
            return;
        }

        for(int i = 0; i < this.nums.length; i++) {
            if(!this.used[i]) {
                tempResult.add(nums[i]);
                this.used[i] = true;
                recurse(tempResult);

                this.used[i] = false;
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    // 计算特征数，以滤除相同的结果
    private int calcCharacteristicNumber(List<Integer> tempResult) {
        int charaNum = 0; // -200000000 < charaNum <= 200000000, 用int足够
        for(Integer i : tempResult) {
            charaNum = charaNum * 20 + i; // -10 <= nums[i] <= 10
        }
        return charaNum;
    }
}
