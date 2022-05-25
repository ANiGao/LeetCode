package array_;

public class Array_59 {
    public int[][] generateMatrix(int n) {

        int[][] arr = new int[n][n];
        boolean index = true;
        //对:错  上:下(存数时行在上还是下的判断)  右:左(存数时列在右还是左的判断)
        boolean indexReverse = false;
        //是否反转赋值  对:错 反:不反(行上存时为正序，下存时为反序)
        boolean reverse = true;
        //对:错  排行:排列
        int a = 0, b = 0;
        //arr[a][b]
        int count = 1;
        //需要存进去的数
        int line = -1;
        //行，到具体存数时依照line来算
        int row = n;
        //列，到具体存数时依照row来算
        int n2 = n * n;
        while (count <= n2) {
            if (reverse) {
                //选定排行或者列
                //排行
                if (index) {
                    //开始
                    //选定行数
                    a = ++line;

                } else {
                    a = n - line - 1;
                }
                /*
                    如果 n = 6
                    a = 0
                        5
                        1
                        4
                        2
                        3
                     */
                if (!indexReverse) {
                    //是否反转赋值
                    //不反
                    for (int i = 0; i < n; i++) {
                        if (arr[a][i] == 0) {
                            arr[a][i] = count;
                            count++;
                        }
                    }
                } else {
                    //反
                    for (int i = n - 1; i >= 0; i--) {
                        if (arr[a][i] == 0) {
                            arr[a][i] = count;
                            count++;
                        }
                    }
                }
                reverse = false;
                //排完一行，下次一列
            }
            ////////

            else {
                //排列
                if (!index) {
                    index = true;
                    //选定列值
                    b = n - b - 1;
                } else {
                    //开始
                    index = false;
                    b = --row;
                }
                /*
                如果 n = 6
                b = 5
                    0
                    4
                    1
                    3
                    2
                 */
                System.out.println();
                if (!indexReverse) {
                    //是否反转赋值
                    //不反
                    for (int i = 0; i < n; i++) {
                        if (arr[i][b] == 0) {
                            arr[i][b] = count;
                            count++;
                        }
                    }
                    indexReverse = true;
                    //横正序，列正序排完。下次反序
                } else {
                    //反
                    for (int i = n - 1; i >= 0; i--) {
                        if (arr[i][b] == 0) {
                            arr[i][b] = count;
                            count++;
                        }
                    }
                    indexReverse = false;
                    //
                }
                reverse = true;
                //排完一列，下次一行
            }
        }
        return arr;
    }




    /*
    index = 0
    i=0     , j     , index=1
    i       , j=n-1
    i=n-1   , j
    i       , j=0

    i=1     , j    //加判空
    i       , j=n-2
    i=n-2   , j
    i       , j=1
    */

    //

    public static void main(String[] args) {
        Array_59 so = new Array_59();
        int n = 10;
        int[][] brr = so.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(brr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

