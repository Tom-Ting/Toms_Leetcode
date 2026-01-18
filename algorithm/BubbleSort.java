import java.util.Arrays;
public class BubbleSort {

    /**
     * 基础冒泡排序（升序）
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        // 外层循环：控制排序轮数，每轮确定一个最大元素的位置
        for (int i = 0; i < n - 1; i++) {
            // 内层循环：相邻元素比较和交换
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果前面的元素大于后面的元素，则交换
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化版本1：添加提前终止标志
     * 如果某一轮没有发生交换，说明已经有序，可以提前结束
     */
    public static void bubbleSortOptimized(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 是否发生交换的标志

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // 如果这一轮没有发生交换，说明数组已经有序
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 优化版本2：记录最后一次交换的位置
     * 可以减少不必要的比较次数
     */
    public static void bubbleSortOptimized2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        int lastSwapIndex = n - 1; // 记录最后一次交换的位置
        int currentSwapIndex;

        for (int i = 0; i < n - 1; i++) {
            currentSwapIndex = 0; // 当前轮次最后交换的位置
            boolean swapped = false;

            // 只需要比较到上一轮最后交换的位置
            for (int j = 0; j < lastSwapIndex; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    currentSwapIndex = j; // 更新最后交换的位置
                }
            }

            lastSwapIndex = currentSwapIndex;

            // 如果没有发生交换，提前结束
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 降序排序的冒泡排序
     */
    public static void bubbleSortDescending(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                // 改变比较方向：前面的元素小于后面的元素时交换
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 通用冒泡排序（支持自定义比较器）
     */
    public static <T extends Comparable<T>> void bubbleSortGeneric(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                // 使用 compareTo 方法进行比较
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 可视化冒泡排序过程
     * 用于理解和调试算法
     */
    public static void bubbleSortVisualized(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        System.out.println("初始数组: " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n第 " + (i + 1) + " 轮排序:");
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                // 显示当前比较的元素
                System.out.printf("  比较 arr[%d]=%d 和 arr[%d]=%d",
                        j, arr[j], j + 1, arr[j + 1]);

                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println(" -> 交换");
                } else {
                    System.out.println(" -> 不交换");
                }
            }

            // 显示本轮排序后的结果
            System.out.println("  第 " + (i + 1) + " 轮结果: " + Arrays.toString(arr));

            if (!swapped) {
                System.out.println("  已完全有序，提前结束");
                break;
            }
        }

        System.out.println("\n最终排序结果: " + Arrays.toString(arr));
    }

    /**
     * 测试主函数
     */
    public static void main(String[] args) {
        // 测试用例
        int[] testArray1 = {64, 34, 25, 12, 22, 11, 90};
        int[] testArray2 = {5, 1, 4, 2, 8};
        int[] testArray3 = {1, 2, 3, 4, 5};  // 已排序数组
        int[] testArray4 = {5, 4, 3, 2, 1};  // 逆序数组
        int[] testArray5 = {3};              // 单个元素

        System.out.println("=== 冒泡排序测试 ===\n");

        // 测试基础版本
        int[] arr1 = testArray1.clone();
        System.out.println("原数组: " + Arrays.toString(testArray1));
        bubbleSort(arr1);
        System.out.println("升序排序: " + Arrays.toString(arr1));

        // 测试优化版本
        int[] arr2 = testArray1.clone();
        bubbleSortOptimized(arr2);
        System.out.println("优化版本: " + Arrays.toString(arr2));

        // 测试降序排序
        int[] arr3 = testArray1.clone();
        bubbleSortDescending(arr3);
        System.out.println("降序排序: " + Arrays.toString(arr3) + "\n");

        // 测试已排序数组
        int[] arr4 = testArray3.clone();
        System.out.println("已排序数组测试: " + Arrays.toString(testArray3));
        bubbleSortOptimized(arr4);
        System.out.println("排序后: " + Arrays.toString(arr4) + "\n");

        // 测试通用版本
        String[] strArray = {"banana", "apple", "orange", "grape", "cherry"};
        System.out.println("字符串数组排序测试:");
        System.out.println("排序前: " + Arrays.toString(strArray));
        bubbleSortGeneric(strArray);
        System.out.println("排序后: " + Arrays.toString(strArray) + "\n");

        // 可视化排序过程
        int[] visualArray = {5, 3, 8, 1, 2};
        System.out.println("=== 可视化冒泡排序过程 ===");
        bubbleSortVisualized(visualArray.clone());
    }
}
