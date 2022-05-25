package competition;

import java.util.Arrays;

public class LC1_1 {
    public static void main(String[] args) {
        int[] gem = {100, 0, 50, 100};
        int[][] operations = {{0,2},{0,1},{3,0},{3,0}};
        Solution1_1 so = new Solution1_1();
        so.giveGem(gem,operations);
    }
}

class Solution1_1 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].length != 2 || operations[i][0] >= gem.length || operations[i][1] >= gem.length) {
                return 0;
            }
            if (!giveAway(gem, operations[i])){
                return 0;
            }

        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];

    }

    public boolean giveAway(int[] gem, int[] arr) {
        int temp = gem[arr[0]] / 2;
        if (temp > gem[arr[0]]){
            return false;
        }
        gem[arr[0]] -= temp;
        gem[arr[1]] += temp;
        return true;
    }
}