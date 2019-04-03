package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetcodeSortingAndSearching {

    public static void main(String[] args) {

    }

    /**
     * 合并两个有序数组 倒序比对
     * 如果某个数组已经比对完（m<0||n<0）就直接复制另一个数组的数据 不用比较了
     * @param nums1 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * @param m     数量
     * @param nums2 2
     * @param n     数量
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        for (int i = m + n - 1; i >= 0; i--) {
            if (n - 1 < 0 || (m - 1 >= 0) && nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
