import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

public class T79_E_Search {
    public boolean exist(char[][] board, String word) {
        if (Objects.equals(word, "")){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHeadAt(board, visited, i, j, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existHeadAt(char[][] board, boolean[][] visited, int i, int j, String word){
        if (Objects.equals(word, "")){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if (visited[i][j]){
            return false;
        }
        if (board[i][j] == word.charAt(0)){
            visited[i][j] = true;
            String ord = word.substring(1);
            boolean exists =  existHeadAt(board, visited, i - 1, j, ord) ||
                    existHeadAt(board, visited, i, j - 1, ord) ||
                    existHeadAt(board, visited, i + 1, j, ord) ||
                    existHeadAt(board, visited, i, j + 1, ord);
            visited[i][j] = false;
            return exists;
        }
        return false;
    }
    @Test
    public void Test(){
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));

        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));

        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "AB"));

        System.out.println(exist(new char[][]{
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        }, "aaaaaaaaaaaaaaaaaaaaaaaaaa"));

        System.out.println(exist(new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        }, "AAB"));
    }
}
/*
    本题难点：标记位置是否访问的数组如何不被乱改？那就是在改完之后进行判断，判断完再改回来。
    回溯法的一大核心就是不能重复回溯
 */
