import org.junit.Test;

public class T96_M {
    // 思路借鉴
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[n] = Sum(dp[i]*dp[n-i-1])
        for (int i = 2; i < n+1; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    @Test
    public void Test(){
        System.out.println(numTrees(1));
        System.out.println(numTrees(3));
    }
}
