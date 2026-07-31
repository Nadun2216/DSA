import java.util.Scanner;

public class OptimizedQuickSort {

    static void quickSort(int[] arr, int low, int high) {
        while (low < high) {

            if (high - low < 10) {
                insertionSort(arr, low, high);
                break;
            }

            int pivot = partition(arr, low, high);

            if (pivot - low < high - pivot) {
                quickSort(arr, low, pivot - 1);
                low = pivot + 1;
            } else {
                quickSort(arr, pivot + 1, high);
                high = pivot - 1;
            }
        }
    }

    static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);

        swap(arr, mid, high);

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");
        printArray(arr);

        sc.close();
    }
}