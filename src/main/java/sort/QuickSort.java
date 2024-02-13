package sort;

public class QuickSort {


    public static void quickSort(int[] a, int n){
        quickSortInternally(a, 0, n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p>= r) return;
        // 找分区点
        int q = partition(a, p, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = 0;
        int j = p;

        return 0;
    }
}
