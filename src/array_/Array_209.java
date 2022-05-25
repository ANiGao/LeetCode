package array_;

public class Array_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right + 1 - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

        //
    }


    public static void main(String[] args) {
        Array_209 so = new Array_209();

        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        int n = 213;
        System.out.println(so.minSubArrayLen(n, nums));
    }
}
