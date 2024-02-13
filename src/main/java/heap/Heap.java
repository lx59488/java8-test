package heap;

public class Heap {

    private int[] a; // 从下标1开始存储
    private int n; // 堆最大可以存储的数据个数
    private int count; // 已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 向一个大顶堆插入一个数据 从下往上堆化
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        count++;
        // 1.将数据放入数组末尾
        a[count] = data;
        // 2.堆化
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // 交换
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 从大顶堆中删除最大元素 从上往下堆化
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        // 将最后一个元素移至堆顶
        a[1] = a[count];
        count--;
        int i = 1;
        while (true) {
            int maxPo = i;
            if (2 * i <= count && a[i] < a[2 * i]) {
                maxPo = 2 * i;
            } else if (2 * i + 1 <= count && a[maxPo] < a[2 * i + 1]) {
                maxPo = 2 * i + 1;
            }
            if (maxPo == i) {
                break;
            }
            // 交换
            swap(a, i, maxPo);
            i = maxPo;
        }
    }

    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }

    }

    /**
     * 建堆
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxP = i;
            if (2 * i <= n && a[i] < a[2 * i]) {
                maxP = 2 * i;
            } else if (2 * i + 1 <= n && a[maxP] < a[2 * i + 1]){
                maxP = 2 * i + 1;
            }
            if (maxP == i) {
                break;
            }
            // 交换
            swap(a, i, maxP);
            i = maxP;
        }
    }

    /**
     * 对排序
     * @param a
     * @param n
     */
    private void sort(int[] a, int n){
        // 建堆
        buildHeap(a, n);
        int k = n;
        while (k >= 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }

    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
