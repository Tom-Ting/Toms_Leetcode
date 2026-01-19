import org.junit.Test;

import java.util.HashMap;

public class T169_E {
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i])+1);
            }else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()){
            if (map.get(key) > N/2){
                return key;
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums){
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
                count++;
            }else if (nums[i] == candidate){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }

    @Test
    public void Test(){
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{0,0,1}));
    }
}
