class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= -1; i--) {
            if(i == -1) {
                int[] result = new int[len + 1];
                result[0] = 1;
                return result;
            }
            if(digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }
}
