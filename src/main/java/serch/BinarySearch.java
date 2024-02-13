package serch;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class BinarySearch {


    /**
     * 二分查找
     * @param a
     * @param n
     * @param target
     * @return
     */
    public static int bSearch(int[] a, int n, int target){
        int left = 0;
        int right = n -1;
        while (left <= right){
            int mid = (left + right)/2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target){
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 找第一个等于给定值的元素
     * @param a
     * @param n
     * @param target
     * @return
     */
    public static int bSearchFirst(int[] a, int n, int target){
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                if (mid == 0 || a[mid - 1] != target) return mid;
                else high = mid -1;
            } else if (a[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 找最后一个等于给定值的元素
     * @param a
     * @param n
     * @param target
     * @return
     */
    public static int bSearchLast(int[] a, int n, int target){
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                if (mid == n -1 || a[mid + 1] != target) return mid;
                else low = mid +1;
            } else if (a[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 找大于等于给定值的第一个元素
     * @param a
     * @param n
     * @param target
     * @return
     */
    public static int bSearch3(int[] a, int n, int target){
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= target) {
                if (mid == 0 || a[mid - 1] < target) return mid;
                else high = mid - 1;
            }  else {
                low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 找小于等于给定值的第一个元素
     * @param a
     * @param n
     * @param target
     * @return
     */
    public static int bSearch4(int[] a, int n, int target){
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= target) {
                if (mid == n - 1 || a[mid + 1] > target) return mid;
                else low = mid + 1;
            }  else {
                high = mid -1;
            }
        }
        return -1;
    }

    /**
     * 二分查找（递归）
     * @param a
     * @param n
     * @param target
     * @return
     */
    public static int bSearchNew(int[] a, int n, int target){
        return bSearchInternally(a, 0, n-1, target);
    }

    private static int bSearchInternally(int[] a, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return bSearchInternally(a, low, mid - 1, target);
        } else {
            return bSearchInternally(a, mid+1, high, target);
        }
    }



}
