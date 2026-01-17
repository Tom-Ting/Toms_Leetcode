import org.junit.Test;

public class T198_M {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = 0;
        dp1[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp0[i] = Math.max(dp0[i-1], dp1[i-1]);
            dp1[i] = dp0[i-1]+nums[i];
        }
        return Math.max(dp0[n-1], dp1[n-1]);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n < 2){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

    @Test
    public void Test(){
        System.out.println(rob2(new int[]{1,2,3,1}));
        System.out.println(rob2(new int[]{2,7,9,3,1}));
    }
}
