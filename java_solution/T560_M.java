import org.junit.Test;

import java.util.HashMap;

public class T560_M {
    public int subarraySum2(int[] nums, int k) {
        int N = nums.length;
        int luckyNum = 0;
        for (int i = 0; i < N; i++) {
            int currentSum = 0;
            for (int j = i; j < N; j++) {
                currentSum += nums[j];
                if (currentSum == k){
                    luckyNum++;
                }
            }
        }
        return luckyNum;
    }

    // 失败，参考答案的算法确实更妙，但是完全没有必要
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        int[] sum = new int[N];
        HashMap<Integer, Integer> sumNum = new HashMap<>();
        sum[0] = nums[0];
        sumNum.put(sum[0], 1);
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + nums[i];
            if (!sumNum.containsKey(sum[i])){
                sumNum.put(sum[i], 1);
            }else {
                sumNum.replace(sum[i], sumNum.get(sum[i] + 1));
            }
        }
        int ans = sumNum.getOrDefault(k, 0);
        for (int s : sum) {
            if (sumNum.containsKey(s - k)) {
                ans += sumNum.get(s - k);
            }
        }
        return ans;
    }
    /*
        遍历一遍数组，从num[0]加到num[i]，结果放到HashMap里
        然后遍历num[i]，然后查HashMap[sum[i] - k]，得到的结果就是"与num[i]之和为k的数量"

     */

    @Test
    public void Test(){
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
        System.out.println(subarraySum(new int[]{1,2,1,2,1}, 3));
        System.out.println(subarraySum(new int[]{1,-1,0}, 0));
        System.out.println(subarraySum(new int[]{1}, 0));
    }
}
