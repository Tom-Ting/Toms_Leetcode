import org.junit.Test;

import java.util.Arrays;

public class T283_E {
    public int[] moveZeroes(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N-1; i++) {
            if (nums[i] == 0){
                for (int j = i; j < N-1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    @Test
    public void Test(){
//        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
//        System.out.println(Arrays.toString(moveZeroes(new int[]{0})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{0,0,1})));
    }
}
