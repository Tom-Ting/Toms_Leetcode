import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class T22_M {
    // 参考思路：使用递归方法
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recrusive(ans, "", 0, 0, n);

        return ans;
    }
    public void recrusive(List<String> ans, String cur, int leftNum, int rightNum, int Max){
        if (leftNum + rightNum == Max*2){
            ans.add(cur);
        }

        if (leftNum < Max){
            recrusive(ans, cur+"(", leftNum+1, rightNum, Max);
        }
        if (rightNum < leftNum){
            recrusive(ans, cur+")", leftNum, rightNum+1, Max);
        }
    }

    @Test
    public void Test(){
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
    }
}
