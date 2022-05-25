package other;

public class LC_73 {
    /*
    关键思想: 用 matrix 第一行和第一列记录该行该列是否有0,作为标志位
    但是对于第一行,和第一列要设置一个标志位,为了防止自己这一行 (一列) 也有 0 的情况.
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        // 第一行和第一列是否有零, 有的话暂时标记起来
        // 注意此时 row0 为 0 还是 col0 为 0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }
        // 把第一行第一列作为标志位, 记录需要置 0 的行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置 0 , 注意细节从一开始
        // 此处暂时不包括 第一行和第一列 ,它俩后续进行处理
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0){
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }if (col0){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
