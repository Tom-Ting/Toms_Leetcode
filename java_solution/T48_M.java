import org.junit.Test;

public class T48_M {
    public void rotate(int[][] matrix) {
        int L = matrix.length;
        for (int i = 0; i < (L+1)/2; i++) {
            for (int j = 0; j < (L-1)/2; j++) {
                bitrotate(matrix, i, j);
            }
        }
    }

    public void bitrotate(int[][] matrix, int i, int j){
        int temp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = matrix[i][j];

    }
    @Test
    public void Test(){
        rotate(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
                });
        rotate(new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        });
    }
}

/*
    1. 位置映射问题
    2. 奇数/偶数截半问题
    3. 整数除法问题
 */
