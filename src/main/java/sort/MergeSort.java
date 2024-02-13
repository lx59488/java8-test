package sort;

public class MergeSort {
    /**
     * 归并排序
     * @param arr
     * @param n
     */
    public static void mergeSort(int[] arr, int n){
        mergeSortInternally(arr, 0, n-1);

    }

    private static void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 找中点，防止int溢出
        int q = p + (r - p)/2;
        // 分
        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q+1, r);
        // 合
        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
        while (i<= q && j<=r) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // 剩余的
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end){
            temp[k] = arr[start];
            k++;
            start++;
        }
        // 拷贝回原数组
        for (int l = 0; l <= r -p; l++) {
            arr[p + l] = temp[l];
        }
    }

    private static void mergeBySentinel(int[] arr, int p, int q, int r){
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];
        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 添加哨兵
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i <= r - q - 1; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
    }
}
