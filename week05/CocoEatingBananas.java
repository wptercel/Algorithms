/**
* 思路：等价于在介于1 - max(piles)之间找到一个临界速度可以让珂珂在h小时内吃完香蕉。二分查找该速度。
* 空间复杂度：O(1)
* 时间复杂度：O(lgn * m)。n为速度区间，m为香蕉堆数。
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int left = 1;
        int right = -1;
        for(int p : piles) {
            right = Math.max(right, p);
        }
        while(left < right) {
            int k = left + (right - left) / 2;
            if(canEatAll(piles, h, k)) {
                right = k;
            } else {
                left = k + 1;
            }
        }
        return right;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int hoursNeed = 0;
        for(int i = 0; i < piles.length; i++) {
            hoursNeed += Math.ceil((double)piles[i] / k);
        }
        return h >= hoursNeed;
    }
}
