package array_;

public class Array_997 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (left < right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left]*nums[left];
                left++;
            } else {
                result[index--] = nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Array_997 so = new Array_997();
        int[] nums = {-4,-1,0,3,10};

        for (int a:so.sortedSquares(nums)){
            System.out.println(a);
        }
    }
}
