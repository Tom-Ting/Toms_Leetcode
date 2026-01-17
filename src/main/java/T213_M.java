import org.junit.Test;

public class T213_M {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0){
            return 0;
        }
        if (N == 1){
            return nums[0];
        }
        if (N == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp0 = new int[N];
        int[] dp1 = new int[N];
        dp0[0] = 0;
        dp0[1] = nums[1];
        dp1[0] = nums[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < N-1; i++) {
            dp0[i] = Math.max(dp0[i-1], dp0[i-2]+nums[i]);
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
        }
        dp0[N-1] = Math.max(dp0[N-2], dp0[N-3]+nums[N-1]);
        dp1[N-1] = dp1[N-2];

        return Math.max(dp0[N-1], dp1[N-1]);
    }

    @Test
    public void Test(){
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1,2,3}));
    }
}
