import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T41_H {
    public int firstMissingPositive1(int[] nums) {
        List<Integer> Nums = new ArrayList<>();
        for (int num : nums) {
            if (num < 1) {
                continue;
            }
            int Loci = FindLocation(Nums, num);
            Nums.add(Loci, num);
        }
        int flag = 1;
        for (Integer num : Nums) {
            if (num == flag) {
                flag++;
            } else if(num < flag){
            } else {
                return flag;
            }
        }
        return flag;
    }

    public int FindLocation(List<Integer>Nums, int nums){
        int i = 0;
        while(i < Nums.size()){
            if (Nums.get(i) > nums){
                break;
            }
            i++;
        }
        return i;
    }

    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] <= 0){
                nums[i] = N+1;
            }
        }
        for (int i = 0; i < N; i++) {
            int Nabs = Math.abs(nums[i]);
            if (Nabs <= N){
                nums[Nabs-1] = -1 * Math.abs(nums[Nabs-1]);
            }
        }
        int flag = 1;
        for (;flag-1 < N; flag++) {
            if (nums[flag-1] > 0){
                return flag;
            }
        }
        return flag;
    }

    @Test
    public void Test(){
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{1,1}));
        System.out.println(firstMissingPositive(new int[]{1}));
    }
}
