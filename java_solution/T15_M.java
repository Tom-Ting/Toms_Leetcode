import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T15_M {
    public List<List<Integer>> threeSum(int[] nums) {
        int Length = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < Length-2; i++) {
            for (int j = i+1; j < Length-1; j++) {
                int sum2 = nums[i] + nums[j];
                for (int k = j+1; k < Length; k++) {
                    if (sum2 + nums[k] == 0){
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[k]);
                        ans.add(tuple);
                    }
                }
            }

        }
        return ans.stream().toList();
    }

    @Test
    public void Test(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
