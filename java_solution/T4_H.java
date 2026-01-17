import org.junit.Test;

public class T4_H {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int step = (m+n)/2 + 1 - 2;
        int point1 = 0;
        int point2 = 0;
        boolean Is1Go = true;
        if (m == 0){
            if (n%2 == 1){
                return nums2[n/2];
            }else {
                return (double) (nums2[n/2-1] + nums2[n/2]) /2;
            }
        }
        if (n == 0){
            if (m%2 == 1){
                return nums1[m/2];
            }else {
                return (double) (nums1[m/2-1] + nums1[m/2]) /2;
            }
        }
        for (int i = 0; i < step; i++) {
            if (point1 >= m-1){
                point2++;
                Is1Go = false;
                continue;
            }
            if (point2 >= n-1){
                point1++;
                Is1Go = true;
                continue;
            }
            if (nums1[point1] < nums2[point2]){
                point1++;
                Is1Go = true;
            }else if (nums1[point1] > nums2[point2]){
                point2++;
            }else {
                if (nums1[point1+1] > nums2[point2+1]){
                    point2++;
                    Is1Go = false;
                }else {
                    point1++;
                    Is1Go = true;
                }
            }
        }
        if ((m+n)%2 == 1){
            if (Is1Go){
                return nums1[point1];
            }
            return nums2[point2];
        }else {
            return (double) (nums1[point1] + nums2[point2]) /2;
        }
    }

    @Test
    public void Test(){
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{-10,-9,-8}, new int[]{1,2}));
    }
}
