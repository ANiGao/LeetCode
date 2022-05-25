package other;

public class LC_48 {
}

class Solution_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 按层遍历
        int temp;
        for (int i = 0; i < n / 2; i++) {
            /*
            // 每一层,四个一组
               最外层 需要多少次
                  (2*n+(n-2)*2)/4 = n-1

               a[i][j]         b[j][n-i-1]


               c[n-j-1][i]     d[n-i-1][n-j-1]
               j++时;
               整体右转
               * a[i][j]                   *
                                     b[j][n-i-1]
               c[n-j-1][i]
               *           d[n-i-1][n-j-1] *
             */
            for (int j = i; j < n - 1 - i; j++) {
                temp = matrix[i][j];
                // a <== c
                matrix[i][j] = matrix[n - j - 1][i];
                // c <== d
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                // d <== b
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                // b <== a
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}