import org.junit.Test;

public class T11_M {
    // 传统思维，最后超时
    public int maxArea_v0(int[] height) {
        int MaxForAll = 0;
        for (int i = 0; i < height.length-1; i++) {
            int MaxForLocI = 0;
            for (int j = i+1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int Water = minHeight*(j-i);
                MaxForLocI = Math.max(MaxForLocI, Water);
            }
            MaxForAll = Math.max(MaxForAll, MaxForLocI);
        }
        return MaxForAll;
    }

    // 最佳思路：双指针解法
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int MaxWater = 0;
        while (left < right){
            int Water;
            if(height[left] < height[right]){
                Water = height[left]*(right-left);
                left++;
            }else {
                Water = height[right]*(right-left);
                right--;
            }
            MaxWater = Math.max(MaxWater, Water);
        }
        return MaxWater;
    }

    @Test
    public void Test(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }
}
