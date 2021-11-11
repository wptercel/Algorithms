/**
* 思路：最小运载力是最大包裹重量，最大运载力是所有包裹重量。利用二分模板找到恰好能在d天中运载所有包裹的运载力。
* 空间复杂度：O(1);
* 时间复杂度：设最大最小运载力之差为m，包裹数量为n。O(lgm*n)
*/
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for(int i = 0; i < weights.length; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
        }

        while(min < max) {
            int mid = min + (max - min) / 2;
            if(validate(weights, days, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean validate(int[] weights, int days, int capacity) {
        int daysNeed = 1;
        int load = 0;
        for(int w : weights) {
            load += w;
            if(load >= capacity) {
                daysNeed++;
                load = load == capacity ? 0 : w;
            }
            if(daysNeed > days) {
                return false;
            }
        }
        return true;
    }
}
