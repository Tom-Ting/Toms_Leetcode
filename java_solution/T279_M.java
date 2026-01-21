import org.junit.Test;

public class T279_M {
    public int numSquares(int n) {
        int[] ans = new int[n+1];
        int s = (int)Math.sqrt(n);
        ans[0] = -1;
        for (int i = 1; i < n+1; i++) {
            ans[i] = 0;
        }
        for (int i = 1; i <= s; i++) {
            ans[i*i] = 1;
        }
        GenAns(ans,n);
        return ans[n];
    }

    public int GenAns(int[] nums, int n){
        if (nums[n] != 0){
            return nums[n];
        }
        int sqrt = (int)Math.sqrt(n);
        int N = n;
        for (int i = sqrt; i > 0; i--) {
            N = Math.min(GenAns(nums, n-i*i)+1, N);
        }
        nums[n] = N;
        return N;

    }

    @Test
    public void Test(){
//        System.out.println(numSquares(16));
//        System.out.println(numSquares(5));
//        System.out.println(numSquares(6));
//        System.out.println(numSquares(18));
//        System.out.println(numSquares(13));
        System.out.println(numSquares(12));
    }
}
