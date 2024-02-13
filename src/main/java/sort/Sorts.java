package sort;

public class Sorts {


    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        if(arr.length <= 1){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int value = arr[i];
            while (j >= 0 && value < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j +1] = value;
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }
}
