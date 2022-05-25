package array_;

public class Array_27 {

    public int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] == val) {
                nums[leftIndex] = nums[rightIndex];
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        Array_27 so = new Array_27();
        int[] arr = {4,6,7,3,6,1};
        int num = 3;
        num = so.removeElement(arr,num);
        for (int a:arr){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println(num);
    }
}
