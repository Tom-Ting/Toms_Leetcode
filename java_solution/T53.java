import org.junit.Test;

public class T53 {
    public int maxSubArray(int[] nums) {
        return -1;
    }

    @Test
    public void Test(){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
