package array_;

public class Array_704 {
    public int search(int[] nums, int target) {
        int lift = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (lift <= right) {
            mid = lift + (right - lift) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                lift = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Array_704 so = new Array_704();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int t = 7;
        System.out.println(so.search(nums, t));
    }
}
