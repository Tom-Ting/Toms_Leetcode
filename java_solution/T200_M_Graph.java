import org.junit.Test;

public class T200_M_Graph {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    num++;
                    paint(grid, i, j);
                }
            }
        }
        return num;
    }

    public void paint(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if (grid[i][j] == '1'){
            grid[i][j] = '2';
            paint(grid, i-1, j);
            paint(grid, i, j-1);
            paint(grid, i+1, j);
            paint(grid, i, j+1);
        }
    }
    @Test
    public void Test(){
        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }
}
