package competition;

public class LC1_2 {
    public static void main(String[] args) {
        Solution1_2 so = new Solution1_2();
        //meterials = [10,10,10,10,10]
        //cookbooks = [[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]]
        //attribute = [[5,5],[6,6],[10,10]]
        //limit = 1
        //
        //输出：11
        int[] materials = {10,10,10,10,10};
        int[][] cookbooks = {{1,1,1,1,1},{3,3,3,3,3},{10,10,10,10,10}};
        int[][] attribute = {{5,5},{6,6},{10,10}};
        int limit = 1;
        System.out.println(so.perfectMenu(materials, cookbooks, attribute, limit));
    }
}

/*
// 五种材料 分别的总量[i]
meterials[i]
// 料理长度 有多少种料理
cookbooks.length
// 制作料理 i 时，所需要的 j 材料的用量
cookbooks[i][j]
//  表示第 i 道料理的美味度 x
attribute[i][0]
mostDelicious
// 表示第 i 道料理的 饱腹感 y
attribute[i][1]
satiety
 */
class Solution1_2 {
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int mostDelicious = 0;
        int satiety = 0;

        // 料理 i
        for (int k = 0; k < cookbooks.length; k++) {
            int m = 0;
            int s = 0;
            int[] mat = new int[5];
            for (int i = 0; i < 5; i++) {
                mat[i] = materials[i];
            }
            int[][] coo = new int[cookbooks.length][5];
            for (int a = 0; a < cookbooks.length; a++) {
                for (int b = 0; b < 5; b++) {
                    coo[a][b] = cookbooks[a][b];
                }
            }
            for (int i = k; i < coo.length; i++) {
                // 可以制作，那就进行制作
                if (make(mat, coo[i])) {
                    s += attribute[i][1];
                    m += attribute[i][0];
                } else {
                    continue;
                }
            }
            if (m > mostDelicious) {
                mostDelicious = m;
                satiety = s;
            }
            else {
                continue;
            }

        }

        if (satiety < limit) {
            return -1;
        } else return mostDelicious;
    }

    // 可以制作，那就进行制作
    // 否则返回 false
    public boolean make(int[] materials, int[] cookbooks) {
        // i 料理所需要的 j 材料的用量
        for (int j = 0; j < 5; j++) {
            // i 料理，是否可以制作
            if (cookbooks[j] > materials[j]) {
                // 不可以制作
                return false;
            }
        }
        // 开始制作进行制作
        for (int j = 0; j < 5; j++) {
            materials[j] -= cookbooks[j];
        }
        return true;
    }
}